package com.shonlee.handle;

import com.shonlee.Utils.ResultUtil;
import com.shonlee.domain.Result;
import com.shonlee.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 专门用来捕获异常信息的类(其他所有的异常全部向上抛出，这里处理异常)
 * Created by ShonLee on 2017/6/7.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    //@ExceptionHandler 用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
    //在@ExceptionHandler之后加入@ResponseBody，就能让处理函数return的内容转换为JSON格式。
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        //判断捕获的异常是否属于我们自己定义的异常，如果是的话，会多一个code的属性
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1, "未知错误！请稍后重试！！！");
        }
    }
}
