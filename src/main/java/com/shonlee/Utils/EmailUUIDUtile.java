package com.shonlee.Utils;

import java.util.UUID;

/**
 * Created by ShonLee on 2017/6/10.
 */
public class EmailUUIDUtile {
    public static String getUUID(){
        //生产随机字符串（32位），并将-替换
        return UUID.randomUUID().toString().replace("-", "");
    }
}
