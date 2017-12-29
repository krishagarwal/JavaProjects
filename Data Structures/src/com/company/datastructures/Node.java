package com.company.datastructures;

class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }

    T getData() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    void setData(T data) {
        this.data = data;
    }
}
