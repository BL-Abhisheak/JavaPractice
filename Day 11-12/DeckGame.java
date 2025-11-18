package com.practice;

class Card {
    String suit;
    String rank;
    int rankValue;

    Card(String suit, String rank, int rankValue) {
        this.suit = suit;
        this.rank = rank;
        this.rankValue = rankValue;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Node {
    Card card;
    Node next;

    Node(Card card) {
        this.card = card;
        this.next = null;
    }
}

class CardQueue {
    Node front, rear;

    void enqueue(Card card) {
        Node node = new Node(card);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    Card dequeue() {
        if (front == null) return null;
        Card card = front.card;
        front = front.next;
        if (front == null) rear = null;
        return card;
    }

    boolean isEmpty() {
        return front == null;
    }

    Card[] toArray() {
        int size = 0;
        Node temp = front;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        Card[] arr = new Card[size];
        temp = front;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.card;
            temp = temp.next;
        }

        return arr;
    }

    void clear() {
        front = rear = null;
    }
}

class Player {
    String name;
    CardQueue cards = new CardQueue();

    Player(String name) {
        this.name = name;
    }

    void sortCards() {
        Card[] arr = cards.toArray();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].rankValue > arr[j + 1].rankValue) {
                    Card temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        cards.clear();
        for (Card c : arr) cards.enqueue(c);
    }

    void printPlayer() {
        System.out.println("Player: " + name);
        System.out.print("Cards: ");
        Node temp = cards.front;
        while (temp != null) {
            System.out.print(temp.card + " | ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
}

class PlayerNode {
    Player player;
    PlayerNode next;

    PlayerNode(Player p) {
        this.player = p;
    }
}

class PlayerQueue {
    PlayerNode front, rear;

    void enqueue(Player p) {
        PlayerNode node = new PlayerNode(p);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    Player dequeue() {
        if (front == null) return null;
        Player p = front.player;
        front = front.next;
        if (front == null) rear = null;
        return p;
    }

    boolean isEmpty() {
        return front == null;
    }
}


public class DeckGame {
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    static Card[] createDeck() {
        Card[] deck = new Card[52];
        int index = 0;

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck[index++] = new Card(suit, ranks[i], i + 2);
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        Card[] deck = createDeck();

        PlayerQueue playerQueue = new PlayerQueue();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
        Player p4 = new Player("Player 4");

        playerQueue.enqueue(p1);
        playerQueue.enqueue(p2);
        playerQueue.enqueue(p3);
        playerQueue.enqueue(p4);

        int cardIndex = 0;

        for (int i = 0; i < 9; i++) {
            p1.cards.enqueue(deck[cardIndex++]);
            p2.cards.enqueue(deck[cardIndex++]);
            p3.cards.enqueue(deck[cardIndex++]);
            p4.cards.enqueue(deck[cardIndex++]);
        }

        p1.sortCards();
        p2.sortCards();
        p3.sortCards();
        p4.sortCards();

        while (!playerQueue.isEmpty()) {
            Player p = playerQueue.dequeue();
            p.printPlayer();
        }
    }
}

