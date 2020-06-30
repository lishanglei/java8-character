package com.java8.defaultinterface;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class DefaultTest {

    public static void main(String[] args) {
        MyInterface impl =new MyInterfaceImpl();
        impl.defaultMethod();
    }
}
