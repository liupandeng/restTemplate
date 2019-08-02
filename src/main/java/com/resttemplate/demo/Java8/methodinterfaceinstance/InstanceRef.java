package com.resttemplate.demo.Java8.methodinterfaceinstance;

import java.util.function.Consumer;

//2.引用特定对象的实例方法
class Bus {
    private int id;
    private String color;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
class Mechanic {
    public void fix(Bus c) {
        System.out.println("Fixing bus " + c.getId());
    }
}
public class InstanceRef {
    public static void main(String[] args) {
        InstanceRef instanceRef = new InstanceRef();
        final Mechanic mechanic = new Mechanic();
        Bus bus = new Bus();

        // Using an anonymous class
        instanceRef.execute(bus, new Consumer<Bus>() {
            public void accept(Bus c) {
                mechanic.fix(c);
            }
        });
        // Using a lambda expression
        instanceRef.execute(bus, bus1 -> mechanic.fix(bus1));
        //Using a method reference
        instanceRef.execute(bus, mechanic::fix);
    }

    private void execute(Bus bus, Consumer<Bus> c) {
        c.accept(bus);
    }
}
