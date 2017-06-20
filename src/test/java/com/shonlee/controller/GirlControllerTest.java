package com.shonlee.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by ShonLee on 2017/6/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGirlList() throws Exception {
        //获取结果的状态码
        mockMvc.perform(MockMvcRequestBuilders.get("/getGirls"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //进行断言比较（返回多数据时不推荐）
        //mockMvc.perform(MockMvcRequestBuilders.get("/getGirls"))
        //        .andExpect(MockMvcResultMatchers.content().string("ssss"));
    }

}