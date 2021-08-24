package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPINGTASK = "ShoppingTask";
    public static final String PAINTINGTASK = "PaintingTask";
    public static final String DRIVINGTASK = "DrivingTask";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Shopping Task","whatever you want",3.0);
            case PAINTINGTASK:
                return new PaintingTask("Painting Task","Oxford Green", "Every car");
            case DRIVINGTASK:
                return new DrivingTask("Driving Task","Rovinj","M340i");
            default:
                return null;
        }
    }
}
