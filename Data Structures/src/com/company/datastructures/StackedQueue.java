package com.company.datastructures;

import com.company.exceptions.QueueOverflowException;
import com.company.exceptions.QueueUnderflowException;

public class StackedQueue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;
    private final int MAX_LENGTH;

    @SafeVarargs
    public StackedQueue(int MAX_LENGTH, T... data) throws QueueOverflowException {
        this.MAX_LENGTH = MAX_LENGTH;
        stack1 = new Stack<>(MAX_LENGTH);
        stack2 = new Stack<>(MAX_LENGTH);

        for (T element : data) {
            enqueue(element);
        }

    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        stack1.push(data);
    }

    public void offer(T data) {
        if (!isFull()) {
            enqueue(data);
        }
    }

    public T dequeue() throws QueueUnderflowException {
        peek();
        return stack2.pop();
    }

    public T peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        if (stack2.isEmpty()) {
            while (stack1.length() != 0) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public boolean isFull() {
        return length() == getMAX_LENGTH();
    }

    public int length() {
        return stack1.length() + stack2.length();
    }

    public int getMAX_LENGTH() {
        return MAX_LENGTH;
    }
}
