package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List myList = loadData();
        Scanner myScan = new Scanner(System.in);

        System.out.println("Welcome To your To-Do-List.");

        ArrayList<Task> myTasks;

        while(true){

            myTasks = myList.getList();
            saveData(myList);

            System.out.println("\nEnter:");
            System.out.println("'1' to add a regular task");
            System.out.println("'2' to add a repeating task");
            System.out.println("'3' to mark any task done");
            System.out.println("'4' to remove any task");
            System.out.println("'5' to show your To-Do-List");
            System.out.println("'6' to exit the To-Do-List");
            int userInput = myScan.nextInt();

            if(userInput == 1 || userInput == 2){
                System.out.println("\nWhat is the title of this task?");
                myScan.nextLine();
                String title = myScan.nextLine();

                System.out.println("What (numbered) month is the task due in?");
                int monthDue = myScan.nextInt();

                System.out.println("What day of month is the task due on?");
                int dayDue = myScan.nextInt();

                System.out.println("What year is the task due in?");
                int yearDue = myScan.nextInt();

                if(userInput == 2){
                    System.out.println("The task repeats every:");

                    System.out.println("_ months, _ days, and _ years.");

                    System.out.println("Months: ");
                    int repeatMonth = myScan.nextInt();

                    System.out.println("Days: ");
                    int repeatDay = myScan.nextInt();

                    System.out.println("Years: ");
                    int repeatYear = myScan.nextInt();

                    System.out.println("What (numbered) month should the task stop repeating?");
                    int monthStopRepeat = myScan.nextInt();

                    System.out.println("What day of month should the task stop repeating?");
                    int dayStopRepeat = myScan.nextInt();

                    System.out.println("What year should the task stop repeating?");
                    int yearStopRepeat = myScan.nextInt();

                    myList.addTask(new RepeatedTask(title, yearDue, monthDue, dayDue, repeatYear, repeatMonth, repeatDay, yearStopRepeat, monthStopRepeat, dayStopRepeat));

                } else{
                    myList.addTask(new Task(title, yearDue, monthDue, dayDue));
                }

                System.out.println("The task has been added to your To-Do-List.");

            } else if(userInput == 3){
                System.out.println("\nWhat is the title of the task you want to mark done?");
                myScan.nextLine();
                String taskTitle = myScan.nextLine();

                int taskIndex = findTaskIndex(myTasks, taskTitle);

                if(taskIndex == -1){
                    System.out.println("The task wasn't found. Start over.");
                } else{
                    myList.markTaskDone(myTasks.get(findTaskIndex(myTasks, taskTitle)));

                    System.out.println("The task was marked done.");
                }

            } else if(userInput == 4){
                System.out.println("\nWhat is the title of the task you want to remove?");
                myScan.nextLine();
                String taskTitle = myScan.nextLine();
                int index = findTaskIndex(myTasks, taskTitle);

                if(index == -1){
                    System.out.println("That task was not found in your list.");
                } else{
                    myList.removeTask(myTasks.get(index));
                    System.out.println("The task was removed.");
                }
            } else if(userInput == 5){
                System.out.println("\n" + myList.toString());
            } else if(userInput == 6){
                break;
            } else{
                System.out.println("\nThat is an unrecognized request. Try again.");
            }
        }

        saveData(myList);

        System.out.println("\nThank you for using To-Do-List.");
    }

    private static int findTaskIndex(ArrayList<Task> myTasks, String taskTitle){
        for(int i = 0; i < myTasks.size(); i++){
            if(myTasks.get(i).getTitle().equalsIgnoreCase(taskTitle)){
                return i;
            }
        }
        return -1;
    }

    private static void saveData(List myList){
        try{
            PrintWriter writer = new PrintWriter("To-Do-List.txt", "UTF-8");
            ArrayList<Task> myTasks = myList.getList();

            for(Task myTask : myTasks){

                writer.print(myTask.getTitle() + ", " + myTask.getDueDate());

                if(myTask.getClass().equals(RepeatedTask.class)){
                    RepeatedTask current = (RepeatedTask)myTask;
                    writer.print(", " + current.getRepeatValues()[0] + ", " + current.getRepeatValues()[1] + ", "
                            + current.getRepeatValues()[2] + ", " + current.getRepeatTill());
                }

                writer.print("\n");
            }

            writer.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static List loadData(){
        File txtFile = new File("To-Do-List.txt");
        List myList = new List();

        try{
            Scanner myScan = new Scanner(txtFile);

            while(myScan.hasNextLine()){
                String[] temp = myScan.nextLine().split(", ");

                LocalDate due = LocalDate.parse(temp[1]);

                if(temp.length == 6){

                    LocalDate repTill = LocalDate.parse(temp[5]);

                    myList.addTask(new RepeatedTask(temp[0], due.getYear(), due.getMonthValue(), due.getDayOfMonth(), Integer.parseInt(temp[2]),
                            Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), repTill.getYear(),
                            repTill.getMonthValue(), repTill.getDayOfMonth()));
                } else{
                    myList.addTask(new Task(temp[0], due.getYear(), due.getMonthValue(), due.getDayOfMonth()));
                }
            }

        } catch(FileNotFoundException e){
            System.out.println("Hello new user.");
        }


        return myList;
    }

}
