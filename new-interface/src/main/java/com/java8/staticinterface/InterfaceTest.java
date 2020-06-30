package com.java8.staticinterface;

/**
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class InterfaceTest {

    public static void main(String[] args) {

        MyInterface.staticMethod();
        //接口的static方法不能被子接口继承
        //SonOfMyInterface.staticMethod();
    }
}
