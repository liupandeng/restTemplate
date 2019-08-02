package com.resttemplate.demo.Java8.methodinterfaceinstance;

import java.util.Arrays;
import java.util.List;

//2.引用特定对象的实例方法
interface Consumer{
    void recive(Integer n);
}

class TestA{
    void sameRe(Integer n){
        System.out.println(n+"+30="+(n+30));
    }
}
public class ObjectInf {
    //一个函数式接口
    //一个类A中的方法和函数式接口的方法类似，该方法有具体的实现，只是方法名不同
    //一个类B引用a对象的实例方法
    public static void main(String[] args) {
        TestA testA = new TestA();
        //对list中的每个元素加30，并打印
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //匿名类实现
        System.out.println("匿名类实现=======");
        evel(list, new Consumer() {
            @Override
            public void recive(Integer n) {
                testA.sameRe(n);
            }
        });
        //lamda表达式
        System.out.println("lamda表达式=======");
        evel(list,n->testA.sameRe(n));
        //引用特定对象的方法 obj::method
        System.out.println("引用特定对象的方法=====");
        evel(list,testA::sameRe);

    }
    static void evel(List<Integer> list,Consumer consumer){
        for(Integer s :list){
            consumer.recive(s);
        }
    }
}
