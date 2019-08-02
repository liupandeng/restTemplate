package com.resttemplate.demo.Java8.methodinterfaceinstance;


import java.util.Arrays;
import java.util.List;
//静态引用
interface Oushu{
    void  getNum(Integer n);
}

public class StaticMetnodInf {
    public static void evenNum(Integer num){
        if(num%2==0)
        System.out.println(num);
    }
    public static void evel(List<Integer> list,Oushu oushu){
        for(Integer n: list){
            oushu.getNum(n);
        }
    }

    public static void main(String[] args) {
        StaticMetnodInf s = new StaticMetnodInf();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        //找出list中的所有偶数
        //匿名类实现函数接口
        System.out.println("匿名类=============");
        evel(list, new Oushu() {
            @Override
            public void getNum(Integer n) {
                evenNum(n);
            }
        });
        //lamda表达式
        System.out.println("lamda表达式=============");
        evel(list,n->evenNum(n));
        //静态引用
        System.out.println("静态引用=============");
        evel(list,StaticMetnodInf::evenNum);
    }
}
