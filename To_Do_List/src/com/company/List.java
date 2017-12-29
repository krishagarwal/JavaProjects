package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

class List {

    private ArrayList<Task> tasks = new ArrayList<>();

    void addTask(Task task){
        tasks.add(task);
    }

    ArrayList<Task> getList(){

        for(int i = 0; i < tasks.size(); i++){

            if(tasks.get(i).isTaskDone()){
                tasks.remove(tasks.get(i));
            }

            else{
                for(int j = 0; j < i; j++){
                    if(tasks.get(i).compareTo(tasks.get(j)) < 0){
                        Task temp2 = tasks.get(i);
                        tasks.remove(i);
                        tasks.add(j, temp2);
                    }
                }
            }
        }

        return (ArrayList<Task>) tasks.clone();
    }

    public String toString(){
        String returnVal = "";

        for(int i = 0; i < tasks.size(); i++){
            LocalDate dueDate = tasks.get(i).getDueDate();

            returnVal += (i+1) + ") Title: " + tasks.get(i).getTitle() + ".";

            if(dueDate.equals(LocalDate.now())){
                returnVal += "\n   Due: TODAY.";
            } else if(dueDate.equals(LocalDate.now().plusDays(1))){
                returnVal += "\n   Due: TOMORROW.";
            } else if(dueDate.equals(LocalDate.now().minusDays(1))){
                returnVal += "\n   Due: YESTERDAY.";
            } else{
                returnVal += "\n   Due: "
                        + dueDate.getDayOfWeek().toString().substring(0, 1) + dueDate.getDayOfWeek().toString().substring(1).toLowerCase() + ", "
                        + dueDate.getMonth().toString().substring(0, 1) + dueDate.getMonth().toString().substring(1).toLowerCase() + " " + dueDate.getDayOfMonth() + ", " + dueDate.getYear() + ".";
            }

            if(LocalDate.now().compareTo(dueDate) > 0){
                returnVal += " OVERDUE.";
            }

            if(tasks.get(i).getClass().equals(RepeatedTask.class)){
                RepeatedTask repeatTask = (RepeatedTask)tasks.get(i);
                LocalDate repeatTill = repeatTask.getRepeatTill();

                returnVal += "\n   Repeats every " + (repeatTask.getRepeatValues()[1]) + " months, " + (repeatTask.getRepeatValues()[2])
                            + " days, and " + (repeatTask.getRepeatValues()[0]) + " years.";

                if(repeatTill.equals(LocalDate.now())){
                    returnVal += "\n   Repeat ends: TODAY.\n";
                } else if(repeatTill.equals(LocalDate.now().plusDays(1))){
                    returnVal += "\n   Repeat ends: TOMORROW.\n";
                } else{
                    returnVal += "\n   Repeat ends: " + repeatTill.getDayOfWeek().toString().substring(0, 1) + repeatTill.getDayOfWeek().toString().substring(1).toLowerCase()
                            + ", " + repeatTill.getMonth().toString().substring(0, 1) + repeatTill.getMonth().toString().substring(1).toLowerCase() + " "
                            + repeatTill.getDayOfMonth() + ", " + repeatTill.getYear() + ".\n";
                }
            } else{
                returnVal += "\n   No repeat.\n";
            }

            returnVal += "\n";

        }

        if(tasks.size() == 0){
            return "Hooray! No tasks in your list.";
        }

        return returnVal;
    }

    void removeTask(Task task){
        tasks.remove(task);
    }

    void markTaskDone(Task task){
        if(task.getClass().equals(RepeatedTask.class)){
            RepeatedTask other = (RepeatedTask)task;
            other.markDone();
        } else{
            task.isDone = true;
        }
    }

}
