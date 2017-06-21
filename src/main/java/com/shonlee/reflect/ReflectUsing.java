package com.shonlee.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类方法反射的基本运用
 * Created by ShonLee on 2017/6/21.
 */
public class ReflectUsing {
    public static void main(String[] args) {
        A a = new A();
        //获取类的方法(信息),首先获取类的类类型
        Class c = a.getClass();
        try {
            //获取类的方法（两种方式，参考 GetReflectMessage.java），方法=名称+参数列表
            //Method print = c.getMethod("print", new Class[]{int.class, int.class});和下面的方法一样
            Method print = c.getMethod("print", int.class, int.class);
            //方法的反射操作，通过a中的方法对象(print)来操作a（反过来操作）
            //方法的反射操作结果和a.print(1,2)的结果一样
            print.invoke(a, 1, 2);
            System.out.println("-------------------------------------------------------");

            Method print1 = c.getMethod("print", int.class, String.class);
            print1.invoke(a, 12, "  nihao");
            System.out.println("-------------------------------------------------------");

            Method print2 = c.getMethod("print", String.class, String.class);
            print2.invoke(a, "Hello World", "   nihao");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print() {
        System.out.println("Hello World");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a + b);
    }

    public void print(int a, String b) {
        System.out.println(a + b);
    }
}