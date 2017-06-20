package com.shonlee.reflect;

/**
 * Created by ShonLee on 2017/6/20.
 */
public class ClassDemo {
    /**
     * class1、class2、class3官网表示为Foo类的ClassType（类类型）
     * @param args
     */
    public static void main(String[] args) {
    Foo foo=new Foo();
    Class class1=Foo.class;
    Class class2=foo.getClass();
    Class class3=null;
        try {
            class3=Class.forName("com.shonlee.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(class1==class3);
    // 可以通过类的类类型来获得类的实例对象，不再需要new，但要进行强制转换
        try {
            Foo foo1= (Foo) class3.newInstance();
            System.out.println("通过反射调用的："+foo1.getaa());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}

class Foo{
    String getaa(){
        return "你好 啊";
    }
}