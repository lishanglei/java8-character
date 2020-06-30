package com.java8;

import java.util.function.Supplier;

/**
 * Supplier  不接收参数,返回要给值
 * @author lishanglei
 * @version v1.0.0
 * @date 2020/6/29
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/6/29              lishanglei      v1.0.0           Created
 */
public class supplier {

    public static void main(String[] args) {
//        Supplier<String> supplier = () -> "这是返回的字符串对象";
//        System.out.println(supplier.get());

        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get());
    }


    static class Student {
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Student() {
            this.name = "name";
            this.age = 18;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
