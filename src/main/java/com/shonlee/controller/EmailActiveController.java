package com.shonlee.controller;

import com.shonlee.Utils.EmailUUIDUtile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ShonLee on 2017/6/10.
 */
@RestController
public class EmailActiveController {
    @GetMapping("Active")
    public void getCode(@RequestParam("code") String code){
        String codeUtil=EmailUUIDUtile.getUUID();
        System.out.println("controller接受test的code值为："+code);
        System.out.println("controller自己调用方法得到的codeUtil值为："+codeUtil);
        if (code==codeUtil){
            System.out.println("code和codeUtil相等");
        }else {
            System.out.println("code和codeUtil不相等");
        }
    }
}
