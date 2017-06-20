package com.shonlee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ShonLee on 2017/6/12.
 */
@Controller
public class PortalController {
    @RequestMapping("/")
    public String ToAdmin(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today", dateFormat.format(cal.getTime()));


        model.addAttribute("hello", "要死了");
        model.addAttribute("date", new Date());
        return "index";
    }


}
