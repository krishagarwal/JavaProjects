package com.company.datastructures;

import com.company.exceptions.NegativeQueueSizeException;
import com.company.exceptions.QueueOverflowException;
import com.company.exceptions.QueueUnderflowException;

public class Queue<T> {

    private LinkedList<T> linkedList;
    private final int MAX_LENGTH;

    @SafeVarargs
    public Queue(int MAX_LENGTH, T... data) throws NegativeQueueSizeException {
        if (MAX_LENGTH < 0) {
            throw new NegativeQueueSizeException();
        }

        this.MAX_LENGTH = MAX_LENGTH;
        linkedList = new LinkedList<>();

        for (T element : data) {
            enqueue(element);
        }
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }

        linkedList.add(data);
    }

    public T dequeue() throws QueueUnderflowException {
        T data = peek();
        linkedList.delete(0);
        return data;
    }

    public T peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        return linkedList.get(0);
    }

    public void offer(T data) {
        if (!isFull()) {
            enqueue(data);
        }
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
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
