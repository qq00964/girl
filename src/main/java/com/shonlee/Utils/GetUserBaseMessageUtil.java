package com.shonlee.Utils;

import com.shonlee.domain.WeChatUserBaseMessage;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * Created by ShonLee on 2017/6/16.
 */
public class GetUserBaseMessageUtil {
    private static Logger logger = Logger.getLogger(WeChatUrlConnection.class);

    public static WeChatUserBaseMessage getUserBaseMessage(String accessToken, String openId) {
        WeChatUserBaseMessage userBaseMessage = null;
        String requestUrl = WeChatFinals.getUserMessageRequestUrl();
        String request = WeChatUrlConnection.httpsRequest(requestUrl, "GET", null);
        try {
            // 将json字符串转为java对象
            JSONObject jsObject = JSONObject.fromObject(request);
            userBaseMessage.setSubscribe(jsObject.getInt("subscribe"));
            userBaseMessage.setOpenid(jsObject.getString("openid"));
            userBaseMessage.setNickname(jsObject.getString("nickname"));
            userBaseMessage.setSex(jsObject.getInt("sex"));
            userBaseMessage.setLanguage(jsObject.getString("language"));
            userBaseMessage.setCity(jsObject.getString("city"));
            userBaseMessage.setProvince(jsObject.getString("province"));
            userBaseMessage.setCountry(jsObject.getString("country"));
            userBaseMessage.setHeadimgurl(jsObject.getString("headimgurl"));
            userBaseMessage.setSubscribe_time(jsObject.getInt("subscribe_time"));
            userBaseMessage.setUnionid(jsObject.getString("unionid"));
            userBaseMessage.setRemark(jsObject.getString("unionid"));
            userBaseMessage.setGroupid(jsObject.getInt("groupid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBaseMessage;
    }
}
