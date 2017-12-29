package com.company;

public class Sorter {

    public static <T extends Comparable> void selectionSort(T[] array) {
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            swap(i, min, array);
        }
    }

    public static <T extends Comparable> void bubbleSort(T[] array) {

        int swaps = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1].compareTo(array[i]) < 0) {
                swap(i, i + 1, array);
                swaps++;
            }


            if (i == array.length - 2) {
                if (swaps == 0) {
                    return;
                }

                i = -1;
                swaps = 0;
            }

        }
    }


    public <T> void insertionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {

        }
    }


    private static <T> void swap(int pos1, int pos2, T[] array) {
        T temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;

    }

    private static <T> void insert(int from, int to, T[] array) {

        if (from == to) {
            return;
        }

        swap(from, to, array);

        if (from > to) {
            insert(from, to + 1, array);
        } else {
            insert(from, to - 1, array);
        }
    }

    private static <T> void findWhereBelongs(T[] array) {

    }


}
