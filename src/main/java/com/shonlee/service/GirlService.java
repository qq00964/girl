package com.shonlee.service;

import com.shonlee.domain.Girl;
import com.shonlee.enums.ResultEnum;
import com.shonlee.exception.GirlException;
import com.shonlee.repostory.GirlRepostoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ShonLee on 2017/6/7.
 */
@Service
@Transactional
public class GirlService {
    @Autowired
    GirlRepostoryJpa girlRepostory;


    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("G");
        girlA.setMoney("20");
        girlRepostory.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(28);
        girlB.setCupSize("G");
        girlB.setMoney("20");
        girlRepostory.save(girlB);
    }

    /**
     * NB 的查找妹子年龄的方法
     */
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepostory.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回 “你还在上小学吧！妹子”
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回 “你可能在上初中了哦！”
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果大于16岁，那就要加钱咯！
        //.......
    }

    /**
     * 通过id查询Girl
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepostory.findOne(id);
    }
}
