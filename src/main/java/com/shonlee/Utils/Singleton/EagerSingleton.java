package com.shonlee.Utils.Singleton;

/**
 * 饿汉式单例模式
 * <p>
 * 1，私有化构造函数；
 * 2，创建私有并静态的本类对象；
 * 3，定义公有并静态的方法，返回该对象。
 * <p>
 * Created by ShonLee on 2017/6/13.
 * <p>
 * 解决的问题：保证一个类在内存中的对象唯一性。
 * <p>
 * 比如：多程序读取一个配置文件时，建议配置文件封装成对象。
 * 会方便操作其中数据，又要保证多个程序读到的是同一个配置文件对象，
 * 就需要该配置文件对象在内存中是唯一的。
 */
public class EagerSingleton {
    /**
     * 1，私有化构造函数；
     */
    private EagerSingleton() {
    }

    /**
     * 2，创建私有并静态的本类对象；初始化
     */
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    /**
     * 3，定义公有并静态的方法，返回该对象。
     */
    public static EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }
}
