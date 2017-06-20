package com.shonlee.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * Created by ShonLee on 2017/6/8.
 * 用于测试获取配置文件(application.yml)中的属性值
 *
 */
@Component
public class Porper {

    /**字符串*/
    @Value("${com.shonlee.name}")
    private String name;

    /**随机字符串*/
    @Value("${com.shonlee.value}")
    private String randomValue;

    /**字符串*/
    @Value("${com.shonlee.title}")
    private String title;

    /**字符串*/
    @Value("${com.shonlee.work}")
    private String work;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Porper{" +
                "name='" + name + '\'' +
                ", randomValue='" + randomValue + '\'' +
                ", title='" + title + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
