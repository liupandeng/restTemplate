package com.resttemplate.demo.Java8.methodinterfaceinstance;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConstructorInf {
    //无参构造
    // Using an anonymous class
    Supplier<List<String>> s = new Supplier() {
        public List<String> get() {
            return new ArrayList<String>();
        }
    };
    List<String> l = s.get();
    // Using a lambda expression
    Supplier<List<String>> s1 = () -> new ArrayList<String>();
    List<String> l1 = s1.get();
    // Using a method reference
    Supplier<List<String>> s2 = ArrayList::new;
    List<String> l2 = s2.get();


    //有参构造
    // Using a anonymous class
    BiFunction<String, String, Locale> f = new BiFunction<String, String, Locale>() {
        public Locale apply(String lang, String country) {
            return new Locale(lang, country);
        }
    };
    Locale loc = f.apply("en","UK");

    // Using a lambda expression
    BiFunction<String, String, Locale> f1 = (lang, country) -> new Locale(lang, country);
    Locale loc1 = f1.apply("en","UK");

    // Using a method reference
    BiFunction<String, String, Locale> f2 = Locale::new;
    Locale loc2 = f2.apply("en","UK");

}
