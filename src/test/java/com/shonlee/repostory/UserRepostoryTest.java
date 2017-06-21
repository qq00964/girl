package com.shonlee.repostory;

import com.shonlee.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ShonLee on 2017/6/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepostoryTest {
    private UserMapperMybatis userMapperMybatis;

    @Autowired
    public void setUserMapperMybatis(UserMapperMybatis userMapperMybatis) {
        this.userMapperMybatis = userMapperMybatis;
    }

    @Test
    public void getUser(){
        User user = userMapperMybatis.findByName("DDD");
        Assert.assertEquals(new Integer(12),user.getAge());
    }

    @Test
    public void getUserByProvider(){
        User user = userMapperMybatis.findByIdProvider(10L);
        Assert.assertEquals("DDD",user.getName());
    }

    @Test
    public void insetUserByProvider(){
        String name="111";
        Integer age=111;
        Double height=111d;
        int i = userMapperMybatis.insertUserProvider(name, age, height);
        System.out.println("受影响的行数为："+i);
    }
}
