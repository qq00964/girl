package com.shonlee.service;

import com.shonlee.domain.User;
import com.shonlee.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by ShonLee on 2017/6/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByName() throws Exception {
        User user=userService.getUser("DDD");
        Assert.assertEquals(new Integer(12),user.getAge());
    }


/*

    @Test
    public void findByNameProvider() throws Exception {
    }

    @Test
    public void insertUser() throws Exception {
    }

    @Test
    public void insertUserProvider() throws Exception {
    }
*/

}