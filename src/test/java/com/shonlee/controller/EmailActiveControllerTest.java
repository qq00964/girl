package com.shonlee.controller;

import com.shonlee.Utils.EmailUUIDUtile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by ShonLee on 2017/6/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmailActiveControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getCode() throws Exception {
        String code=EmailUUIDUtile.getUUID();
        System.out.println("test传入controller的code值为："+code);
        //获取结果的状态码
        mockMvc.perform(MockMvcRequestBuilders.get("/Active?code="+code+""))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}