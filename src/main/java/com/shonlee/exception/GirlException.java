package com.shonlee.exception;

import com.shonlee.enums.ResultEnum;

/**
 * Created by ShonLee on 2017/6/7.
 *
 * RuntimeException可以进行事物回滚，Exception不能进行事物回滚
 */
public class GirlException extends RuntimeException {
    /**错误代码*/
    private Integer code;

    /**
     * 构造一个基本异常.标准格式，可以通过多态的方法插入不同的参数，实现多个自定义异常
     *
     * 覆写构造方法，添加父类的message属性
     *@param resultEnum 信息的描述，通过ResultEnum类的成员变量来实现
     */
    public GirlException(ResultEnum resultEnum) {
        // 调用父类构造函数初始化message
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
