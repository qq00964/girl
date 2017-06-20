package com.shonlee.Utils.Singleton;

/**
 * 懒汉式单例:延迟加载方式。
 * <p>
 * 1，私有化构造函数；
 * 2，创建私有并静态的本类对象；
 * 3，定义公有并静态的方法，返回该对象。
 * <p>
 * Created by ShonLee on 2017/6/13.
 */
public class LazySingleton {
    private LazySingleton() {
    }

    /**
     * 2，创建私有并静态的本类对象；不初始化，调用的时候在初始化
     */
    private static LazySingleton lazySingleton = null;

    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
