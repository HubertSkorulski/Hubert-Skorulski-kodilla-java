package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(1,2);
        } catch (SecondChallengeException e) {
            System.out.println("Some problems");
        }
    }

}
