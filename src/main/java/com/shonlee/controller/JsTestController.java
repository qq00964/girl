package com.shonlee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by ShonLee on 2017/6/28.
 */
@Controller
@RequestMapping("jsTest")
public class JsTestController {
    public static final Logger logger = LoggerFactory.getLogger(JsTestController.class);

    @GetMapping("hello")
    public String jspTest() {
        return "/testJs";
    }
}
