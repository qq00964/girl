package com.shonlee.domain;

import org.springframework.web.bind.annotation.CookieValue;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ShonLee on 2017/6/9.
 */
public class User {

    private Long id;
    private String name;
    private Integer age;
    private Double height;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
