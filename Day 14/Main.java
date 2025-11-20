package com.prac;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println("Pushing elements onto the stack:");
        stack.push(70);
        stack.push(30);
        stack.push(56);

        System.out.print("Stack after pushing all elements: ");
        stack.display();

        System.out.println("\nPeeking and popping until stack is empty:");

        while (!stack.isEmpty()) {
            System.out.println("Peek: " + stack.peek());
            System.out.println("Pop: " + stack.pop());
            System.out.print("Current stack: ");
            stack.display();
            System.out.println();
        }

        try {
            stack.peek();
        } catch (RuntimeException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
