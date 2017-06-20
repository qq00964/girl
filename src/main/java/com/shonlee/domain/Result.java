package com.shonlee.domain;

/**
 * http 请求返回的最外层对象,如下：
 *
 * {
 *     code
 *     message
 *     data
 * }
 * Created by ShonLee on 2017/6/7.
 */
public class Result<T> {
    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回的结果集
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return data;
    }

    public void setResult(T result) {
        this.data = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + data +
                '}';
    }
}
