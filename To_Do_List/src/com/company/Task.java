package com.company;

import java.time.LocalDate;

class Task implements Comparable{

    private String title;
    protected boolean isDone;
    protected LocalDate dueDate;

    Task(String title, int yearDue, int monthDue, int dayDue){
        this.title = title;
        isDone = false;

        String currentYear = String.valueOf(LocalDate.now().getYear());
        String date = "";

        if(String.valueOf(yearDue).length() < 4) {
            date += (currentYear.substring(0, 2));
        }

        if(String.valueOf(yearDue).length() == 1){
            date += "0";
        }

        date += yearDue + "-";

        if((long)(monthDue/10) < 1){
            date += "0";
        }

        date += monthDue + "-";

        if((long)(dayDue/10) < 1){
            date += "0";
        }

        date += dayDue;

        dueDate = LocalDate.parse(date);
    }

    @Override
    public int compareTo(Object o) {
        Task other = (Task)o;
        return this.dueDate.compareTo(other.dueDate);
    }

    String getTitle(){
        return title;
    }

    LocalDate getDueDate(){
        return dueDate;
    }

    boolean isTaskDone(){
        return isDone;
    }

    void switchIsDone(){
        isDone = !isDone;
    }
}
