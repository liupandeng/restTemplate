package com.resttemplate.demo.Java8;


public class FinalScope {
//    //lambda 表达式只能引用标记了 final 的外层局部变量
//     final static int i=30;
//    public static void main(String[] args) {
//
//        Opp a = (x)-> x+i;
//        System.out.println("100+i="+a.add(100));
//    }
//
//    interface Opp{
//        int add(int x);
//    }

//    final static String salutation = "Hello! ";
//
//    public static void main(String args[]){
//        GreetingService greetService1 = message ->
//                System.out.println(salutation + message);
//        greetService1.sayMessage("Runoob");
//    }
//
//    interface GreetingService {
//        void sayMessage(String message);
//    }
public static void main(String args[]) {
    final int num = 1;
    Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
    s.convert(2);  // 输出结果为 3
}

    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
