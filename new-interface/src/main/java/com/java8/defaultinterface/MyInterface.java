package com.java8.defaultinterface;

/**
 * default关键词修饰的方法是对该抽象方法一种默认的实现
 * 可以被继承类或者实现类重写
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public interface MyInterface {

    default void defaultMethod() {
        System.out.println("hello java8 default method ...");
    }
}
