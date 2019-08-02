package com.resttemplate.demo.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class People {

    public double calculateWeight() {
        double weight = 0;
        // Calculate weight
        return weight;
    }

    public List<Double> calculateAllWeight(List<People> l, Function<People, Double> f) {
        List<Double> results = new ArrayList<>();
        for (People s : l) {
            results.add(f.apply(s));
        }
        return results;
    }
}

class PeopleClient {
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        People p = new People();
        // Using an anonymous class
        p.calculateAllWeight(list, new Function<People, Double>() {
            @Override
            public Double apply(People people) {// The object
                return people.calculateWeight();// The method
            }
        });
        // Using a lambda expression
        p.calculateAllWeight(list, people -> people.calculateWeight());
        // Using a method reference
        p.calculateAllWeight(list, People::calculateWeight);
    }
}
