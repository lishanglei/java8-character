package com.java8.lambda;

/**
 * Lambda表达式可以看成是对匿名内部类的简写,使用Lambda表达式时,接口必须是函数式接口
 * 作用域:
 * 在lambda表达式中访问外层作用域和老版本的匿名对象中的方式相似,
 * 可以直接访问标记了final的外部局部变量,或者实例的字段及静态变量,但如果访问局部变量
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class MyTest {
    //实例变量
    int score =20;
    //静态变量
    static int salary=10000;
    public static void main(String[] args) {

        //局部变量
        int age =9;

        /**实现类*/
        MyInterface myInterface =new MyInterfaceImpl();
        System.out.println(myInterface.sum(2,3));

        /**匿名内部类*/
        MyInterface myInterface1 =new MyInterface() {

            public int sum(int num1, int num2) {
                return num1+num2;
            }
        };
        System.out.println(
              myInterface1.sum(3,5)
        );

        /**lambda表达式*/
        MyInterface myInterface2 =(int num1,int num2)->{
            /**
             * 访问局部变量,则该局部变量则默认被final修饰,不能改变值
             */
            //age=10;
            System.out.println(age);
            System.out.println(new MyTest().score);
            System.out.println(salary);
            return num1+num2;
        };

        System.out.println(myInterface2.sum(8,9));
        /**
         * lambda表达式简写
         * 1.形参类型可以省略
         * 2.如果方法体中只有一句,可以省略{}
         * 3.如果是return返回结果的,可以省略掉return
         * 4.如果只有一个参数,()也可以省略
         */
        //MyInterface myInterface3 =(num1,num2)->num1+num2;

    }
}
