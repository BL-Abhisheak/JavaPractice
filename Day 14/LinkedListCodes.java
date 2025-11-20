package com.practice;


public class LinkedListCodes<T extends Comparable<T>> {

    Node<T> head;

    class Node<T> {
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void append(T data){
        Node<T> newNode = new Node<>(data);

        if (head == null){
            head = newNode;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void insertAtPosition(int position, T data){
        if (position == 0){
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> temp = head;

        for (int i = 1; i < position; i++){
            if (temp == null){
                throw new IndexOutOfBoundsException("Invalid position");
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public T pop(){
        if (head == null)
            throw new RuntimeException("List Empty!");

        T val = head.data;
        head = head.next;
        return val;
    }

    public T popLast(){
        if (head == null)
            throw new RuntimeException("List Empty!");

        if (head.next == null){
            T val = head.data;
            head = null;
            return val;
        }

        Node<T> temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }

        T val = temp.next.data;
        temp.next = null;
        return val;
    }

    public Node<T> search(T key){
        Node<T> temp = head;
        while (temp != null){
            if (temp.data.equals(key))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean insertAfter(T key, T data){
        Node<T> node = search(key);
        if (node == null)
            return false;

        Node<T> newNode = new Node<>(data);
        newNode.next = node.next;
        node.next = newNode;

        return true;
    }

    public boolean deleteByKey(T key){
        if (head == null)
            return false;

        if (head.data.equals(key)){
            head = head.next;
            return true;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(key)){
            temp = temp.next;
        }

        if (temp.next == null)
            return false;

        temp.next = temp.next.next;
        return true;
    }

    public int size(){
        int count = 0;
        Node<T> temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display(){
        Node<T> temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

