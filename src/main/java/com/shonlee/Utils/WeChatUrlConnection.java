package com.shonlee.Utils;

import com.shonlee.domain.WeChatAccessToken;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * Created by ShonLee on 2017/6/12.
 */
public class WeChatUrlConnection {
    private static Logger logger = Logger.getLogger(WeChatUrlConnection.class);
    /**
     * 获取AccessToken的请求地址（GET）
     */
    public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方法
     * @param outputStr 传递的参数
     *
     * @author Administrator
     *
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        try {
            // /1、解决https请求的问题

            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new GetX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            // /2、兼容GET、POST两种方式

            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            // /3、兼容有数据提交、无数据提交两种情况

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
        } catch (ConnectException ce) {
            ce.printStackTrace();
            logger.error("服务器连接超时！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出错了！");
        }
        return buffer.toString();
    }

    /**
     * 获取accessToken
     *
     * @param appID 开发者ID 公众号的唯一凭证
     * @param appSecret 开发者密码
     * @return Token 对象
     */
    public static WeChatAccessToken getAccessToken(String appID, String appSecret) {
        WeChatAccessToken token = null;
        // 拼接请求地址
        String requestUrl = TOKEN_URL.replace("APPID", appID).replace("APPSECRET", appSecret);
        String request = httpsRequest(requestUrl, "GET", null);
        try {
            // 将json字符串转为java对象
            JSONObject jsObject = JSONObject.fromObject(request);
            String accessToken = jsObject.getString("access_token");
            int expiresIn = jsObject.getInt("expires_in");
            token = new WeChatAccessToken();
            token.setExpiresIn(expiresIn);
            token.setAccessToken(accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
