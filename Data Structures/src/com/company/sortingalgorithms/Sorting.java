package com.company.sortingalgorithms;

public final class Sorting {

    private Sorting() {
    }

    public static <T extends Comparable> void selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static <T extends Comparable> void bubbleSort(T[] array) {

        boolean swapped = false;

        while (true){
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }

            swapped = false;
        }

    }

    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
