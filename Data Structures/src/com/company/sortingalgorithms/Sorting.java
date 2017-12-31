package com.company.sortingalgorithms;

public abstract class Sorting {

    public static <T extends Comparable> void selectionSort(T[] array){
        for (int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i].compareTo(array[j]) < 0){
                    swap(array, i, j);
                }
            }
        }
    }

    private static <T> void swap(T[] array, int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
