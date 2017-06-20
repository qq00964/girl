package com.shonlee.controller;

import com.shonlee.Utils.ResultUtil;
import com.shonlee.domain.Girl;
import com.shonlee.domain.Result;
import com.shonlee.repostory.GirlRepostoryJpa;
import com.shonlee.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ShonLee on 2017/6/7.
 */
@RestController
public class GirlController {

    private final static Logger Logger = LoggerFactory.getLogger(GirlController.class);
    /**
     * 使用类型注入
     */
    @Autowired
    private GirlRepostoryJpa girlRepostory;

    /**
     * 使用构建器注入 girlService
     */
    private GirlService girlService;

    @Autowired
    public GirlController(GirlService girlService) {
        this.girlService = girlService;
    }

    // 插入一个妹子
    //@Valid Girl girl 对传入的girl对象进行验证，验证的结果放在bindingResult对象里面
    @PostMapping("insert")
    public Result<Girl> insert(@Valid Girl girl, BindingResult bindingResult) {
        // 如果验证结果不通过
        if (bindingResult.hasErrors()) {
            return null;
            //打印获取到的错误信息
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        Logger.info(girl.getMoney());

        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        girl.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRepostory.save(girl));
    }

    //查询所有girl信息
    @GetMapping("getGirls")
    public List<Girl> getGirlList() {
        return girlRepostory.findAll();
    }

    //查询一个女生
    @GetMapping("/girl/{id}")
    public Girl getGirl(@PathVariable("id") Integer id) {
        return girlRepostory.findOne(id);
    }

    //通过年龄查询girl
    @GetMapping("/findByAge/{age}")
    public List<Girl> findGirls(@PathVariable("age") Integer age) {
        return girlRepostory.findByAge(age);
    }

    //同时插入两个girl
    @PostMapping("saveTwoGirl")
    public void save() {
        girlService.insertTwo();
    }


    /**
     * NB 的查找妹子年龄的方法
     */
    @GetMapping("girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}

