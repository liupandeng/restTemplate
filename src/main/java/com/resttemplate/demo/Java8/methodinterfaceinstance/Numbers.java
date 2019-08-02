package com.resttemplate.demo.Java8.methodinterfaceinstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Numbers {
    //将值判断提取成静态方法
    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }
    //公共接口方法
    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : l) {
            if (p.test(i, i + 10)) {
                newList.add(i);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);
        // Using an anonymous class
        List<Integer> res = Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                return Numbers.isMoreThanFifty(integer, integer2);
            }
        });
        res.stream().forEach(System.out :: println);
//        res.stream().peek(System.out :: println).collect(Collectors.toList());
        // Using a lambda expression
        Numbers.findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));
        // Using a method reference
        Numbers.findNumbers(list, Numbers::isMoreThanFifty);
    }
}
