package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework implements ObservableHomework {
    private String homeworkTopic; //to jako np zadania moduł pierwszy
    private List<String> tasks; //i tu dodawac zadania z modulu pierwszego
    private HomeworkObserver mentor;

    public Homework(String homeworkTopic) {
        this.homeworkTopic = homeworkTopic;
        this.tasks = new ArrayList<>();
    }

    public String getTopic() {
        return homeworkTopic;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyMentor();
    }

    @Override
    public void registerMentor(HomeworkObserver homeworkObserver) {
        this.mentor = homeworkObserver;
    }

    @Override
    public void notifyMentor() {
        mentor.update(this);
    }

}
