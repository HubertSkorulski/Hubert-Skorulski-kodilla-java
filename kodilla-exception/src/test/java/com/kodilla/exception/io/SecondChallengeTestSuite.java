package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import com.kodilla.exception.test.SecondChallengeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    @Test
    void correctAnswer() throws SecondChallengeException {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        Assertions.assertEquals("Done!",secondChallenge.probablyIWillThrowException(1,2));
    }

    @Test
    void x15y2() throws SecondChallengeException {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertDoesNotThrow(()-> secondChallenge.probablyIWillThrowException(1.5,2));
    }
    @Test
    void x2y15() throws SecondChallengeException {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertThrows(SecondChallengeException.class,()-> secondChallenge.probablyIWillThrowException(2,1.5));
    }
    @Test
    void x1y15() throws SecondChallengeException {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        assertThrows(SecondChallengeException.class,()->secondChallenge.probablyIWillThrowException(1,1.5));
    }
}
