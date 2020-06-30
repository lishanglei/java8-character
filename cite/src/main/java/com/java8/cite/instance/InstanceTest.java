package com.java8.cite.instance;

import java.util.function.Function;

/**
 * 实例方法引用
 * java8提供了Function接口,接口中的两个泛型,一个作为参数,一个作为返回值
 *
 *  @FunctionalInterface
 *  public interface Function<T,R>{
 *      R apply(T t);
 *  }
 *
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */

public class InstanceTest {

    public static void main(String[] args) {

        /**
         * 1.使用匿名内部类
         */
        Function function =new Function<String,Boolean>() {
            @Override
            public Boolean apply(String s) {
                return s.endsWith("java");
            }
        };
        System.out.println(function.apply("hello.java"));


        /**
         * 使用匿名内部类
         */
        Function<String,Boolean> function1 =(s)->s.endsWith(s);
        System.out.println(function1.apply("你好.java"));


        /**
         * 实例方法引用
         */
        Function<String,Boolean> function2 ="world.java"::endsWith;
        System.out.println(function2.apply("java"));
    }
}
