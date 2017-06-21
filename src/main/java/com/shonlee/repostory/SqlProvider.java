package com.shonlee.repostory;


/**
 * 提供CRUD的sql语句，用于@Provider的注解方式
 * Created by ShonLee on 2017/6/21.
 */
public class SqlProvider {
    public String findByIdProvider(Long id) {
        String selectSql = "select * from user WHERE id = ";
        return selectSql + id;
    }

    public String insertUserProvider(String name, Integer age, Double height) {
        String insertSql = new StringBuilder("insert into user(name,age,height) values ")
                .append("( '" + name+"'")
                .append("," + age + ",")
                .append(height + ")")
                .toString();
        return insertSql;
    }
}