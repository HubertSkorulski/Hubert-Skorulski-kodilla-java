package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        TaskList toDo = (TaskList) context.getBean("toDoList");
        TaskList inPr = (TaskList) context.getBean("inProgressList");
        TaskList done = (TaskList) context.getBean("doneList");
        toDo.add("Wash");
        inPr.add("Clean");
        done.add("Write");
        //Then
        System.out.println(toDo);
        System.out.println(inPr);
        System.out.println(done);

    }
}
