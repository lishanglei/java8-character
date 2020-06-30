# java8新特性
### 1.接口的静态方法和默认方法
    java8之前,接口只允许存在抽象方法,即默认被public abstract修饰
    java8新增静态方法和默认方法
######1.1静态方法
1.接口中允许存在被static修饰的方法且该方法必须有方法体 

2.接口中的static方法只能够被接口本身调用: 接口名.静态方法名(...) 

3.接口的static方法不能被子接口继承

4.接口的static方法不能给被实现类重写及直接调用 
   
    public interface MyInterface {

    //接口中的方法默认使用public abstract修饰
    public abstract void test();
    
    //java8中允许接口中存在静态方法,该静态方法必须包含方法体
    static void staticMethod(){
        System.out.println("hello java8  static method  ...");
    };
    }
######1.2默认方法
default关键词修饰的方法是对该抽象方法一种默认的实现,可以被继承类或者实现类重写

        public interface MyInterface {
        
            default void defaultMethod() {
                System.out.println("hello java8 default method ...");
            }
        }
        
###2.函数式接口(Functional Interface)
就是有且仅有一个抽象方法,但是可以有多个非抽象方法的接口,函数式接口可以被隐式转换为lambda表达式

    @FunctionalInterface
    public interface FunctionInterface {

        void test();
        /**
         * 当接口中有且只有一个抽象方法时,
         * 可以在接口上添加@FunctionalInterface注解
         */
        //void test3();
    
        static void test1(){};
    
        default void test2(){};
    }
JDK1.8之前已有的函数式接口
 
    java.lang.Runnable   
    java.util.concurrent.Callable
    java.security.PrivilegedAction
    java.util.Comparator
    java.io.FileFilter
    java.nio.PathMatcher
    java.lang.reflect.InvocationHandler
    java.beans.PropertyChangeListener
    java.awt.event.ActionListener
    javax.swing.event.ChangeListener
 
 
JDK1.8新增的函数接口

    java.util.Function
###3.lambda表达式
Lambda表达式可以看成是对匿名内部类的简写,使用Lambda表达式时,接口必须是函数式接口
#####lambda表达式的作用域:
 * 在lambda表达式中访问外层作用域和老版本的匿名对象中的方式相似,
 * 可以直接访问标记了final的外部局部变量,或者实例的字段及静态变量,但如果访问局部变量
 
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
###4.构造方法引用 / 静态方法引用 / 实例方法引用

######4.1构造方法引用
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
######4.2静态方法引用
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
######4.3实例方法引用
    public class InstanceTest {
    
        public static void main(String[] args) {
    
            /**
             * 1.使用匿名内部类
             */
            Function function =new Function<String,Boolean>() {
                @Override
                public Boolean apply(String s) {
                    return s.endsWith("java");
                }
            };
            System.out.println(function.apply("hello.java"));
    
            /**
             * 使用匿名内部类
             */
            Function<String,Boolean> function1 =(s)->s.endsWith(s);
            System.out.println(function1.apply("你好.java"));
    
            /**
             * 实例方法引用
             */
            Function<String,Boolean> function2 ="world.java"::endsWith;
            System.out.println(function2.apply("java"));
        }
    }
###5.Predicate函数式接口
接收一个泛型,返回一个boolean类型的结果
######源码
    @FunctionalInterface
    public interface Predicate<T> {
         boolean test(T t);
    }
######演示   
    public class PredicateTest {
    
        public static void main(String[] args) {
            Predicate<Integer> predicate = age -> age > 10;
            System.out.println(predicate.test(17));
    
            Predicate<Integer> predicate1=age->age<30;
            Predicate<Integer> predicate2 = predicate.and(predicate1);
            System.out.println(predicate2.test(8));
        }
    }
    
###6.Consumer函数式接口
接收一个泛型,没有返回类型
######源码
    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }
######演示   
    public class ConsumerTest {
        public static void main(String[] args) {
    
            Consumer<String> consumer =out::print;
            consumer.accept("abc");
        }
    }
###7.Supplier
接收一个泛型,返回该泛型
######源码
    @FunctionalInterface
    public interface Supplier<T> {
    
        T get();
    }

######演示   
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