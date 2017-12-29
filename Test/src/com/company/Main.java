package com.company;

import java.lang.*;

public class Main {

    public static void main(String[] args) {


//        Sorter test
//        String[] array = {"D", "B", "A", "C"};
//        Sorter.bubbleSort(array);
//        System.out.println(Arrays.asList(array));

//        Rhymer test
//        Rhymer.playGame();

//        EmailAddressFinder test
//        EmailAddressFinder.validate();

//        Fibonacci test
//        System.out.println(fibonacci(5));

    }


    private static double fibonacci(int i) {
        if (i <= 2) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

}