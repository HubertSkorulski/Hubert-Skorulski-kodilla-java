package com.kodilla.good.patterns.challenges.productorderservice;

public class SMSInformationService implements InformationService {
    public void inform(User user) {
        System.out.println("Wysyłam SMS:");
        System.out.println("Drogi " + user.getName() + " " + user.getSurname() + " wniosek zakupowy przyjęty");
    }
}
