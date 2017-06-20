package com.shonlee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by ShonLee on 2017/6/9.
 */
@Controller
public class ThymeleafController {
    //@RequestMapping("/helloHtml")
    @GetMapping("helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","你好");
        return "Thymeleaf";
    }
}
