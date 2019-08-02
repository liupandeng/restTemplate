package com.resttemplate.demo.Java8;

 interface MyFunc1 {

    MyClass func(int n);

}
class MyClass {

    private int val;

    MyClass(int v) {
        val = v;
    }

    MyClass(){
        val = 0;
    }

    public int getValue() {
        return val;
    }

}

 class ConstructorRefDemo {

    public static void main(String[] args) {
        MyFunc1 myClassCons = MyClass :: new;
        MyClass mc = myClassCons.func(100);
        System.out.println("val in mc is: " + mc.getValue());
    }
}