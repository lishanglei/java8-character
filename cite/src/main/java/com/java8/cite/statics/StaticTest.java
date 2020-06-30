package com.java8.cite.statics;

/**
 * 静态方法的引用
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class StaticTest {

    public static void main(String[] args) {

        //1.匿名内部类
        ParseInterface parseInterface =new ParseInterface() {
            @Override
            public int parseString(String str) {
                return Integer.parseInt(str);
            }
        };
        System.out.println(parseInterface.parseString("3"));

        //2.lambda表达式写法
        ParseInterface parseInterface1 =(str)->Integer.parseInt(str);
        System.out.println(parseInterface1.parseString("5"));

        //3.静态方法引用
        ParseInterface parseInterface2 =Integer::parseInt;
        System.out.println(parseInterface2.parseString("7"));
    }
}
