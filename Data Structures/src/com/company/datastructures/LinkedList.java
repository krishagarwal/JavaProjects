package com.company.datastructures;

public class LinkedList<T> {

    private Node<T> head;
    private int length;

    @SafeVarargs
    public LinkedList(T... data) {
        head = null;
        length = 0;

        for (T element : data) {
            add(element);
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
        } else {

            Node<T> current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }

        length++;
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> beforeIndex = getNode(index - 1);

            if (beforeIndex.getNext() == null) {
                throw new IndexOutOfBoundsException();
            }

            beforeIndex.setNext(beforeIndex.getNext().getNext());
        }

        length--;
    }

    public void deleteAll() {
        head = null;
        length = 0;
    }

    public void insert(int index, T data) throws IndexOutOfBoundsException {
        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {

            Node<T> beforeIndex = getNode(index - 1);

            newNode.setNext(beforeIndex.getNext());
            beforeIndex.setNext(newNode);
        }
        length++;
    }

    public void set(int index, T data) throws IndexOutOfBoundsException {
        getNode(index).setData(data);
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getData();
    }

    public int length() {
        return length;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {

            if (current.getNext() == null) {
                throw new IndexOutOfBoundsException();
            }

            current = current.getNext();
        }

        return current;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');

        Node<T> current = head;

        while (current != null) {
            result.append(current.getData());
            result.append(", ");
            current = current.getNext();
        }

        if (!(result.length() == 1)) {
            result.delete(result.length() - 2, result.length());
        }

        result.append(']');

        return result.toString();
    }
}
