package com.shonlee.Utils;

import com.shonlee.thread.WeChatAccessTokenThread;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;

/**
 * Created by ShonLee on 2017/6/12.
 */
public class WeChatAccessTokenSave {
    private static Logger logger = Logger.getLogger(WeChatAccessTokenSave.class);

    private static final long serialVersionUID = 1L;

    // Web服务器启动时就加载一个Servlet，在Servlet的init()方法中启动一个线程，在线程的run()方法中通过死循环
    // +Thread.sleep()的方式定期获取access_token，然后将获取到的access_token保存在public static修饰的变量中。
    public void init() throws ServletException {
        WeChatAccessTokenThread.appid = "wx2a1e61969cfaf932";
        WeChatAccessTokenThread.appsecret = "9a9c400db1261c83e34b276b97b285cd";

        logger.info(WeChatAccessTokenThread.appid);
        logger.info(WeChatAccessTokenThread.appsecret);

        // 未配置appid、appsecret时给出提示
        if ("".equals(WeChatAccessTokenThread.appid) || "".equals(WeChatAccessTokenThread.appsecret)) {
            logger.error("appid 或 appsecret 不存在");
        } else {
            // 启动定时获取access_token的线程
            new Thread(new WeChatAccessTokenThread()).start();
        }
    }
}
