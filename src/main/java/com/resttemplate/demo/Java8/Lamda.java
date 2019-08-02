package com.resttemplate.demo.Java8;


public class Lamda {
    public static void main(String[] args) {
        Lamda lamda = new Lamda();
        TestLamda a =  (x,y)-> x+y;
//        System.out.println("10+5 = "+ a.add(10,5));
        System.out.println("10+5 = "+lamda.opp(10,5,a));

        LamdaString s = (mess)-> System.out.println("print:"+ mess);
        s.print("hello lpd");

    }

    interface LamdaString{
        void print(String s);
    }
    interface TestLamda{
        int opp(int x,int y);
    }

    private int opp(int x,int y,TestLamda a){
        return a.opp(x,y);
    }

}
