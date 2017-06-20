package com.shonlee.repostory;

import com.shonlee.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * SpringBoot整合Mybatis CRUD 实例测试
 * Created by ShonLee on 2017/6/9.
 */
@Mapper
@Repository
public interface UserMapperMybatis {
    /**
     * 通过name查询所有
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    /**
     * 通过普通的方式插入一条信息
     */
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     * 通过Map的方式插入一条信息
     */
    @Insert("INSERT INTO user(name,age) VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertMap(Map<String, Object> map);

    /**
     * 通过实体类对象的方式插入一条信息
     */
    @Insert("INSERT INTO user(name,age,height) VALUES(#{name},#{age},#{height})")
    int insertUser(User user);

    /**
     * 通过实体类对象的方式修改一条信息
     */
    @Update("UPDATE user SET name=#{name},height=#{height},age=#{age} WHERE id=#{id}")
    int updateUser(User user);

    /**
     * 通过实体类对象的方式删除一条信息
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    int deleteUser(User user);

    /**
     * 查询实体返回一个result的结果集
     */
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "height", column = "height"),
    })
    @Select("SELECT name,age,height FROM user")
    List<User> findALL();
}

