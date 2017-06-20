package com.shonlee.controller;

import com.shonlee.Utils.GetUserBaseMessageUtil;
import com.shonlee.Utils.WeChatFinals;
import com.shonlee.domain.WeChatUserBaseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ShonLee on 2017/6/16.
 * <p>
 * 微信中有两个accesssToken:
 * <p>
 * 1，基础接口的token 获取接口是
 * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
 * <p>
 * 2，用户网页授权access_token 获取接口地址是
 * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
 * <p>
 */
@Controller
public class WeChatUserBaseMessageController {

    @GetMapping("getUserMessage")
    public String getUserMessage(Model model) {
        String accessToken = WeChatFinals.getAccessToken();
        WeChatUserBaseMessage weChatUserBaseMessages = GetUserBaseMessageUtil.getUserBaseMessage(accessToken, WeChatFinals.OPENID);
        model.addAttribute("weChatUserBaseMessages", weChatUserBaseMessages);
        return "index";
    }
}
