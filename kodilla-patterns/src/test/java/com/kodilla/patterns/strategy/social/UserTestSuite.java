package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User dym = new Millenials("Dym");
        User tym = new YGeneration("Tym");
        User zym = new ZGeneration("Zym");
        //When


        //Then
        assertEquals("Snapchat", zym.publish());
        assertEquals("Facebook",tym.publish());
        assertEquals("Twitter",dym.publish());
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User dym = new Millenials("Dym");

        //When
        dym.setSocialPublisher(new FacebookPublisher());

        //Then
        assertEquals("Facebook",dym.publish());
    }

}
