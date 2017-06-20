package com.shonlee.Utils;

import com.shonlee.domain.Result;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by ShonLee on 2017/6/7.
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setResult(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
