package com.resttemplate.demo.Java8;


import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;

interface Prediction{
    boolean test(Integer n);
}

public class MethodInterface {
    public static void main(String[] args) {
        //lamda表达式实现函数接口
        Prediction p = n -> n%2==0;

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        evel(list,p);
    }
    public  static void evel(List<Integer> l,Prediction prediction){
        for(Integer n:l){
            if(prediction.test(n)){
                System.out.println(n+" ");
            }
        }
    }



}
