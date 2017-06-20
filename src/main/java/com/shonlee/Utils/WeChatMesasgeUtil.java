package com.shonlee.Utils;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ShonLee on 2017/6/12.
 */
public class WeChatMesasgeUtil {
    /**
     * 解析微信发来的明文请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点  （子节点中没有子元素时）
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        /** 遍历所有子节点  （子节点中有子元素时,递归遍历）
         *   recursiveParseXML(root,map);
         */
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }

    /**
     * 解析微信发来的密文请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXmlCrypt(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        /**
         * 第一步：从inputStream中获取密文的XML
         * */
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        //从输入流当中读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        // 每行读取的数据
        String line = null;
        //读取的总数据
        StringBuffer buffer = new StringBuffer();
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        inputStream.close();
        /**
         * 第二步：解密XML为普通的XML文件
         * */
        String msgSignature = request.getParameter("msg_signature");
        String timeStamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        WXBizMsgCrypt wxCrypt = getWxCrypt();
        String fromXML = wxCrypt.decryptMsg(msgSignature, timeStamp, nonce, buffer.toString());
        /**
         * 第三步：对解密后的普通XML进行解析处理
         * */
        Document document = DocumentHelper.parseText(fromXML);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点  （子节点中没有子元素时）
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        /** 遍历所有子节点  （子节点中有子元素时,递归遍历）
         *   recursiveParseXML(root,map);
         */
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }

    /**
     * 获取微信加解密实例
     *
     * @return WXBizMsgCrypt pc
     */
    public static WXBizMsgCrypt getWxCrypt() {
        String appId = "wx2a1e61969cfaf932";
        String encodingAesKey = "IQxcAjIvTzC2pKwVWdXYf6nxenw0wJnajbNY0xRWU9J";
        WXBizMsgCrypt pc = null;
        try {
            pc = new WXBizMsgCrypt(WeChatSignUtil.token, encodingAesKey, appId);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return pc;
    }

    private static void recursiveParseXML(Element root, Map<String, String> map) {
        //得到根节点的所有子节点列表
        @SuppressWarnings("unchecked")
        List<Element> elements = root.elements();
        //判断子节点中有没有子元素列表
        if (elements.size() == 0) {
            map.put(root.getName(), root.getTextTrim());
        } else {
            //   递归    遍历子节点中的子元素
            for (Element element : elements) {
                recursiveParseXML(element, map);
            }
        }
    }

    /**
     * 扩展XStream，使其支持CDATA块
     *
     * @date 2017-5-25 15:10:14
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有XML节点的转换都增加CDATA标记
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}
