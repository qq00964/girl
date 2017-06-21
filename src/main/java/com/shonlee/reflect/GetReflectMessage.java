package com.shonlee.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取类中的成员方法和成员变量的信息
 * Created by ShonLee on 2017/6/21.
 */
public class GetReflectMessage {
    /**
     * @param object 该对象所属的成员方法信息
     *     推荐使用   c.getMethods();  获取类的所有public的方法,包括从父类继承而来的public方法
     *               c.getDeclaredMethods(); 获取类中自己申明的方法,不包括从父类继承而来的方法且不考虑访问权限
     */
    public static void getMethodsMessage(Object object) {
        //获取对应类（object传入的类）的类类型
        Class c = object.getClass();
        //获取类的名称
        System.out.println("类的名称为：" + c.getName());
        //获取类的所有public的方法,包括从父类继承而来的public方法
        Method[] ms = c.getMethods();
        for (int i = 0; i < ms.length; i++) {
            //得到方法的名字
            System.out.println("方法的名字:" + ms[i].getName() + "(");
            //得到方法的返回值类型的类类型，如：String.class int.class
            Class returnType = ms[i].getReturnType();
            //得到方法返回值的名字
            returnType.getName();
            //得到方法的参数类型的类类型
            Class[] parameterTypes = ms[i].getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("方法的参数类型名：" + parameterType.getName());
            }
            System.out.println(")");
        }
        //获取类中自己申明的方法,不包括从父类继承而来的方法且不考虑访问权限
        //Method[] dms = c.getDeclaredMethods();
    }

    /**
     * @param object 该对象所属的成员变量信息
     *               c.getFields();  获取类的所有public的方法,包括从父类继承而来的public方法
     *    推荐使用    c.getDeclaredFields(); 获取类中自己申明的方法,不包括从父类继承而来的方法且不考虑访问权限
     */
    public static void getVariablesMessage(Object object) {
        Class c = object.getClass();
        //c.getFields();
        //获取类中自己申明的方法,不包括从父类继承而来的方法且不考虑访问权限
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //获取成员变量的类型的类类型
            Class type = declaredField.getType();
            System.out.println("成员变量的类型为："+type.getName());
            //获取成员变量的名字
            String name = declaredField.getName();
            System.out.println("成员变量的名字："+name);
        }
    }

    /**
     *
     * @param object 该对象所属的构造方法的信息
     *               c.getConstructors();  获取类的所有public的构造方法,包括从父类继承而来的public构造方法
     *    推荐使用    c.getDeclaredConstructors(); 获取类中自己申明的构造方法,不包括从父类继承而来的方法且不考虑访问权限
     *
     */
    public static void GetConstructorMessage(Object object){
        Class c=object.getClass();
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor.getName()+"(");
            //获取构造函数的参数列表的类类型
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType:parameterTypes) {
                System.out.println(parameterType.getName()+",");
            }
            System.out.println(")");
        }
    }
}