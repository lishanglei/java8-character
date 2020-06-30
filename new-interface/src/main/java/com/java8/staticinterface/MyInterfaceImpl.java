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
public class MyInterfaceImpl implements MyInterface {

    //接口的static方法不能给被实现类重写及直接调用
    @Override
    public void test() {

    }
}
