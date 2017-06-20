package com.shonlee.Utils;

import sun.security.provider.SHA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by ShonLee on 2017/6/12.
 * 微信公众号接入验证
 * 1）将token、timestamp、nonce三个参数进行字典序排序
 * 2）将三个参数字符串拼接成一个字符串进行sha1加密
 * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
 */
public class WeChatSignUtil {
    public static final String SHA="SHA-1";
    public static final String MD5="MD5";

    // 与接口配置信息中的Token要一致
    public static String token="IdeaShonLee";

    /**
     * 验证消息是否来自微信服务器
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return
     */
    public static boolean checkSignature(String signature , String timestamp , String nonce){
        String[] arr=new String[]{token,timestamp,nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序,结果还是有三个参数，只不过位置可能不一样
        Arrays.sort(arr);
        StringBuilder content=new StringBuilder();
        // 将三个数组参数变成三个字符串参数
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            // 接收任意大小的数据，并输出固定长度的哈希值。
            md = MessageDigest.getInstance(WeChatSignUtil.SHA);
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            // 获得密文完成哈希计算,产生128 位的长整数
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for(int i = 0 ; i < byteArray.length ; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0' , '1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , 'A' , 'B' ,
                'C' , 'D' , 'E' , 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
