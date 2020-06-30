package com.java8.cite.cons;

/**
 * 这是一个获得person对象的工厂接口:函数式接口
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public interface PersonFactory {

    /**
     * 获得Person对象的方法
     */
    Person createPerson(String firstName,String secondName);
}
