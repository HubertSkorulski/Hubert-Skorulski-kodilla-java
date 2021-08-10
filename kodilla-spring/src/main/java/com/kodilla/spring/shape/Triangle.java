package com.kodilla.spring.shape;

import com.kodilla.spring.forum.ForumUser;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

    @Override
    public String getShapeName() {
        return "This is a triangle.";

    }
}
