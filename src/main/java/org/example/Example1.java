package org.example;

import org.example.model.User;

public class Example1 {
//    @SuppressWarnings("unused")
    User user = new User("John");
}

class Parent{
    public void run(){}
}

class Child extends Parent{
    @Override
    public void run(){
        System.out.println("overriden method");
    }
}