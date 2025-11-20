package com.prac;

public class LinkedList<T extends Comparable<T>> {
    public Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T pop() {
        if (head == null) {
            throw new RuntimeException("List is empty!");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
