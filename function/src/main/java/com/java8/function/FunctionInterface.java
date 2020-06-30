package com.java8.function;

/**
 * 函数式接口(Functional Interface):
 *  就是有且仅有一个抽象方法,但是可以有多个非抽象方法的接口.
 *  函数式接口可以被隐式转换为lambda表达式
 *
 * JDK1.8之前已有的函数式接口
 * java.lang.Runnable
 * java.util.concurrent.Callable
 * java.security.PrivilegedAction
 * java.util.Comparator
 * java.io.FileFilter
 * java.nio.PathMatcher
 * java.lang.reflect.InvocationHandler
 * java.beans.PropertyChangeListener
 * java.awt.event.ActionListener
 * javax.swing.event.ChangeListener
 *
 * JDK1.8新增的函数接口
 * java.util.Function
 *
 *
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
@FunctionalInterface
public interface FunctionInterface {

    void test();

    /**
     * 当接口中有且只有一个抽象方法时,
     * 可以在接口上添加@FunctionalInterface注解
     */
    //void test3();

    static void test1(){};

    default void test2(){};
}
