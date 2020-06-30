package com.java8.cite.cons;

/**
 * 构造方法的引用
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class ConstructorTest {

    public static void main(String[] args) {

        /**
         * 1.匿名内部类
         */
        PersonFactory factory = new PersonFactory() {
            public Person createPerson(String firstName, String secondName) {
                return new Person(firstName, secondName);
            }
        };

        Person person = factory.createPerson("hello", "world");
        System.out.println(person);


        /**
         * 2.使用lambda表达式
         */
        PersonFactory factory1 = (firstName, secondName) -> new Person(firstName, secondName);

        System.out.println(factory1.createPerson("zhagnsan","lisi"));

        /**
         * 3.lambda表达式简单写法:构造方法引用
         */
        PersonFactory factory2 =Person::new;
        System.out.println(factory2.createPerson("盖伦","诺克"));
    }


}
