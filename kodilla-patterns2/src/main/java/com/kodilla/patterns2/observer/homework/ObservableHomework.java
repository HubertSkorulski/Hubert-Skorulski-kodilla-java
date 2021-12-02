package com.kodilla.patterns2.observer.homework;

public interface ObservableHomework {
    void registerMentor(HomeworkObserver homeworkObserver);
    void notifyMentor();
}
