package com.shonlee.Utils;

import com.shonlee.domain.WeChatAccessToken;

/**
 * Created by ShonLee on 2017/6/16.
 */
public class WeChatFinals {

    public static final String APPID = "wxa967d74f02bd628c";
    //OPENID 获取出错，不是这么简单的
    //https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
    //code需要授权验证后，地址中会有code值，在填写回调地址的时候，不用加Http或Https前缀
    public static final String OPENID = "oTdWdxLOKOQu9J2-Pb4kdtn3Y4e4";
    public static final String APPSECRET = "4538a42c5b403211d79c056e5f9fb0a4";

    /**
     * 获取accessToken
     *
     * @return accessToken
     */
    public static String getAccessToken() {
        WeChatAccessToken weChatAccessToken = WeChatUrlConnection.getAccessToken(APPID, APPSECRET);
        String accessToken = weChatAccessToken.getAccessToken();
        return accessToken;
    }

    /**
     * 获取用户基本信息（包括UnionID机制）
     * http请求方式: GET
     */
    public static final String GETUSERBASEMESSAGE =
            "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * 拼接一个用户的请求地址
     *
     * @return requestUrl
     */
    public static String getUserMessageRequestUrl() {
        String requestUrl = GETUSERBASEMESSAGE.replace("ACCESS_TOKEN", getAccessToken())
                .replace("OPENID", OPENID);
        return requestUrl;
    }

    /**
     * 批量获取用户基本信息
     * http请求方式: POST
     */
    public static final String GETUSERBASEMESSAGElIST =
            "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

    /**
     * 拼接所有用户的请求地址
     *
     * @return requestUrl
     */
    public static String getUserMessageListRequestUrl() {
        String requestUrl = GETUSERBASEMESSAGElIST.replace("ACCESS_TOKEN", getAccessToken());
        return requestUrl;
    }

}
