package com.shonlee.domain;

import org.springframework.stereotype.Repository;

/**
 * Created by ShonLee on 2017/6/7.
 */
@Repository
public class GirlProperties {
    public String getCupSize() {
        return cupSize;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "cupSize='" + cupSize + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private  String cupSize;
    private  String age;

}
