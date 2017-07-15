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
// @RestController 包含controller和response两个功能
//@RestController
@RequestMapping("jsTest")
public class JsTestController {
    public static final Logger logger = LoggerFactory.getLogger(JsTestController.class);

    @GetMapping("hello")
    public String jspTest() {
        return "/testJs";
    }

    @GetMapping("windows")
    public String jsWindowsTest() {
        return "/jsWindowsTest";
    }

    @GetMapping("bootstrap")
    public String bootstrapTest() {
        return "/bootstrap";
    }

    @GetMapping("jsFile")
    public String jsFileTest() {
        return "/jsFileTest";
    }

    @GetMapping("jquery")
    public String jqueryTest() {
        return "/jqueryTest";
    }

}
