# java 的反射

### 1、class类(详见reflect/ClassDemo.java)
   一般累的实例获取方法：
   
  ``` java
  class Foo(){
    ...
  }
    
  Foo foo1=new Foo();
  ```
  
  1.1在面向对象的世界里，万事万物皆是对象（java语言中，静态的成员，普通的类是不是
    是不是对象呢?类是哪个的对象呢？）
    
  任何类都是对象，都是`java.lang.class`类的实例对象，这个实例对象有
  三种表示方式(*获得的实例对象是一样的，因为一个类只有一个Class类的实例对象*)：
  
   a: 实际是告诉我们每一个类都有一个隐含的静态成员变量`class`
   
   `Class class1=Foo.class;`
    
   b: 通过该类的实例对象来调用`getClass()`方法；
   
   `Class class2=foo1.getClass();`
   
   c: 第三种方法
   
   ```java
    Class class3=null;
        try {
            class3=Class.forName("com.shonlee.reflect.ClassDemo.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
   ```
   
   **`class1`、`class2`、`class3`官网表示为`Foo`类的`ClassType`（类类型）**
  
    
  1.2 