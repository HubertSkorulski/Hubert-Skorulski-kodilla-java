package com.kodilla.patterns2.observer.homework;

public class Mentor implements HomeworkObserver {

    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Homework homework) {
        System.out.println(mentorName + ": New task done:  " + homework.getTopic() + "\n" +
                " (total tasks done: " + homework.getTasks().size() + ")");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
