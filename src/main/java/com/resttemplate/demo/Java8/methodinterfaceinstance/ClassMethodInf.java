package com.resttemplate.demo.Java8.methodinterfaceinstance;


import java.util.Arrays;
import java.util.List;
//3.引用某类对象的实例方法
interface OppNum{
    String opp(ClassMethodInf a,Integer n);
}

public class ClassMethodInf {
    //一个函数式接口 接口方法中的参数分别为（某类A对象，其他参数...)
    //一个类A中有一个方法m 方法的参数名和接口的参数名类似，只是没有接口中的第一个参数，返回值类型要和接口方法的对应
    //类A中引用类A对象的方法m

    String addNum(Integer n){
        return (n+"+40="+(n+40));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //对list中的每个元素增加40
        //匿名类实现接口
        System.out.println("匿名类实现接口==========");
        evel(list, new OppNum() {
            @Override
            public String opp(ClassMethodInf a, Integer n) {
                return a.addNum(n);
            }
        });
        //lamda表达式
        System.out.println("lamda表达式==========");
        evel(list,(a,n)->a.addNum(n));
        //引用某类对象的实例方法
        System.out.println("引用某类对象的实例方法==========");
        evel(list,ClassMethodInf::addNum);

    }
    static void evel(List<Integer> list,OppNum oppNum){
        for(Integer s :list){
            System.out.println(oppNum.opp(new ClassMethodInf(),s));
        }
    }
}

