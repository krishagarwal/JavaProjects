package com.company.nestedifs;

public class Main {

    public static void main(String[] args) {
        float students = 0.0f;
        float rooms = 4.0f;

        if (students > 0){
            if (rooms > 0) {
                System.out.println(students / rooms);
            }
        } else {
            System.out.println("No students");
        }

        System.out.println();
        System.out.println("** end program **");
    }
}
