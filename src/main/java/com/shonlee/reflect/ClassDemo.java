package com.shonlee.reflect;

/**
 * Created by ShonLee on 2017/6/20.
 */
public class ClassDemo {
    /**
     * class1、class2、class3官网表示为Foo类的ClassType（类类型）
     *
     * @param args
     */
    public static void main(String[] args) {
        //通过静态的方法(new)加载类的对象，这种方法主要用于程序编译的时候,会出现以下问题：
        //如果程序中有多个new出来的对象，当某一个类不存在的时候编译是不会通过的，相当于100个类，只要有一个类不存在，就无法编译
        Foo foo = new Foo();
        //通过Class的反射加载类的对象，这属于动态加载类的对象，这种方法主要用于程序运行的时候，在需要某一个类的时候再加载
        //因此在编译的时候不会出现静态加载的那种情况
        Class class1 = Foo.class;
        Class class2 = foo.getClass();
        Class class3 = null;
        try {
            class3 = Class.forName("com.shonlee.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("class1 == class3:" + (class1 == class3));
        System.out.println("class2 == class3:" + (class2 == class3));
        // 可以通过类的类类型来获得类的实例对象，不再需要new，但要进行强制转换
        try {
            //一定要注意class3对象获取时调用的类名，强转时就是转换为该类的类型
            Foo foo1 = (Foo) class3.newInstance();
            System.out.println("通过反射调用的：" + foo1.getaa());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}

class Foo {
    String getaa() {
        return "你好 啊!";
    }
}
