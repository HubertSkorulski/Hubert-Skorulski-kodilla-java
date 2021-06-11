package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUserName();

        if(result.equals("theForumUser")) {
            System.out.println("test ok");
        } else {
            System.out.println("Error!");
        }
        // class Calculator tests
        Calculator digits1 = new Calculator();

        int sub = digits1.substract(5,3);
        int adding  = digits1.add(5,1);

        if (sub == 2 && adding == 6) {
            System.out.println("test ok");
        } else {
            System.out.println("error");
        }
    }
}
