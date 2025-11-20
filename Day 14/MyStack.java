package com.prac;

public class MyStack<T extends Comparable<T>> {
    LinkedList<T> list = new LinkedList<>();

    public void push(T data){
        list.addFirst(data);
    }

    public T peek(){
        if (list.head == null)
            throw new RuntimeException("Stack is empty!");
        return list.head.data;
    }

    public T pop(){
        return list.pop();
    }

    public void display(){
        list.display();
    }

    public boolean isEmpty(){
        return list.head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = list.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
