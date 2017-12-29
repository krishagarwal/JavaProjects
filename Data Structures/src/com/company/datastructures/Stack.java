package com.company.datastructures;

import com.company.exceptions.NegativeStackSizeException;
import com.company.exceptions.StackOverflowException;
import com.company.exceptions.StackUnderflowException;

public class Stack<T> {

    private LinkedList<T> linkedList;
    private final int MAX_LENGTH;


    @SafeVarargs
    public Stack(int MAX_LENGTH, T... data) throws NegativeStackSizeException {

        if (MAX_LENGTH < 0) {
            throw new NegativeStackSizeException();
        }

        this.MAX_LENGTH = MAX_LENGTH;
        linkedList = new LinkedList<>();

        for (T value : data) {
            push(value);
        }
    }

    public void push(T data) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }

        linkedList.insert(0, data);
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }

        T data = linkedList.get(0);
        linkedList.delete(0);

        return data;
    }

    public T peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }

        return linkedList.get(0);
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public boolean isFull() {
        return length() == getMAX_LENGTH();
    }

    public int length() {
        return linkedList.length();
    }

    public int getMAX_LENGTH() {
        return MAX_LENGTH;
    }
}
