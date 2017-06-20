package com.shonlee.controller;

import com.shonlee.Utils.WeChatSignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ShonLee on 2017/6/12.
 */
@Controller
public class WeChatController {
    @GetMapping("WeChat")
    /**
     * 处理微信的get请求，并给予响应，验证用户信息
     */
    public String WeChatConlaction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println("signature=" + signature);
        System.out.println("timestamp=" + timestamp);
        System.out.println("nonce=" + nonce);
        PrintWriter out = response.getWriter();
        if (WeChatSignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }else  {
            System.out.println("验证不成功！");
        }
        out.close();
        out = null;
        return echostr;
    }
}
