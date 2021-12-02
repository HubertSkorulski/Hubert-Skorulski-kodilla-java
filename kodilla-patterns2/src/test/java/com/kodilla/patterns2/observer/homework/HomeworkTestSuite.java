package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Mentor firstMentor = new Mentor("First Mentor");
        Mentor secondMentor = new Mentor("Second Mentor");

        Homework firstUserTasks = new Homework("First user tasks");
        Homework secondUserTasks = new Homework("Second user tasks");

        String task11 = "Task 1.1";
        String task12 = "Task 1.2";
        String task21 = "Task 2.1";
        String task22 = "Task 2.2";
        String task23 = "Task 2.3";

        firstUserTasks.registerMentor(firstMentor);
        secondUserTasks.registerMentor(secondMentor);


        //When
        firstUserTasks.addTask(task11);
        firstUserTasks.addTask(task12);
        secondUserTasks.addTask(task11);
        secondUserTasks.addTask(task12);
        secondUserTasks.addTask(task21);

        //Then
        assertEquals(2,firstMentor.getUpdateCount());
        assertEquals(3,secondMentor.getUpdateCount());

    }
}
