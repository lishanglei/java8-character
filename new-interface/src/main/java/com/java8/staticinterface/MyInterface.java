package com.java8.staticinterface;

/**
 * 接口中允许存在被static修饰的方法且该方法必须有方法体
 * 接口中的static方法只能够被接口本身调用: 接口名.静态方法名(...)
 * 接口的static方法不能被子接口继承
 * 接口的static方法不能给被实现类重写及直接调用
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public interface MyInterface {

    //接口中的方法默认使用public abstract修饰
    public abstract void test();

    //java8中允许接口中存在静态方法,该静态方法必须包含方法体
    static void staticMethod(){
        System.out.println("hello java8  static method  ...");
    };
}
