package com.resttemplate.demo.Java8.methodinterfaceinstance;
//3.引用某类对象的实例方法

//java中有一个Function接口可以接收一个参数，BiFunction接口接受两个参数，没有接受三个参数的，所以我们自定义一个TriFunction
interface TriFunction<T, U, V, R> {
  R apply(T t, U u, V v);
}
//然后定义一个类，接收两个参数，并且有一个返回值
class Sum {
  Integer doSum(String s1, String s2) {
    return Integer.parseInt(s1) + Integer.parseInt(s1);
  }
    public static void main(String[] args) {
        //用匿名类实现TriFunction，来包装doSum()
        TriFunction<Sum, String, String, Integer> anonymous =
                new TriFunction<Sum, String, String, Integer>() {
                    @Override
                    public Integer apply(Sum s, String arg1, String arg2) {
                        return s.doSum(arg1, arg2);
                    }
                };
        System.out.println(anonymous.apply(new Sum(), "1", "4"));
        //使用lambda表达式来包装
        TriFunction<Sum, String, String, Integer> lambda =
                (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg2);
        System.out.println(lambda.apply(new Sum(), "1", "4"));
        //使用方法引用 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;
        System.out.println(mRef.apply(new Sum(), "1", "4"));
    }
}



