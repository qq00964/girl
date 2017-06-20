package com.shonlee.thread;

import com.shonlee.Utils.WeChatUrlConnection;
import com.shonlee.domain.WeChatAccessToken;
import org.apache.log4j.Logger;

/**
 * Created by ShonLee on 2017/6/12.
 * 将AccessToken保存到内存中，在一定时间后再次调用方法获取新的AccessToken
 */
public class WeChatAccessTokenThread implements Runnable {

    private static Logger logger = Logger.getLogger(WeChatAccessTokenThread.class);
    // 第三方用户唯一凭证
    public static String appid = "";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "";

    public static WeChatAccessToken accessToken = null;

    /**
     * 每隔7000秒获取一次access_token，保证access_token永不失
     */
    @Override
    public void run() {
        while (true) {
            try {
                accessToken = WeChatUrlConnection.getAccessToken(appid, appsecret);
                if (null != accessToken) {
                    logger.info("获取access_token成功:" + accessToken.getAccessToken());
                    logger.info("有效时长:" + accessToken.getExpiresIn());
                    // 当accessToken存在时，线程休眠7000秒
                    Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e1) {
                    logger.error("{}", e1);
                }
                logger.error("{}", e);
            }
        }
    }

}
