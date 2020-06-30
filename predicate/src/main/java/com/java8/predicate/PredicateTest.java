package com.java8.predicate;

import java.util.function.Predicate;

/**
 * Predicate: 根据传入的参数 返回一个boolean值
 *
 * @FunctionalInterface
 * public interface Predicate<T> {
 *     boolean test(T t);
 * }
 *
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<Integer> predicate = age -> age > 10;
        System.out.println(predicate.test(17));

        Predicate<Integer> predicate1=age->age<30;
        Predicate<Integer> predicate2 = predicate.and(predicate1);
        System.out.println(predicate2.test(8));
    }
}
