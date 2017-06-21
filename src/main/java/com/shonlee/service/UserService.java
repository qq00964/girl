package com.shonlee.service;

import com.shonlee.domain.User;
import com.shonlee.repostory.UserMapperMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ShonLee on 2017/6/21.
 */
@Service
public class UserService {

    @Autowired
    private UserMapperMybatis userMapperMybatis;

    public User getUser(String name){
        User user = userMapperMybatis.findByName(name);
        return user;
    }
}
