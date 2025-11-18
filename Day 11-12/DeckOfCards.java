package com.practice;

import java.util.*;

public class DeckOfCards {

    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[52];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        List<String> cardList = Arrays.asList(deck);
        Collections.shuffle(cardList);

        cardList.toArray(deck);

        String[][] players = new String[4][9];
        int deckIndex = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = deck[deckIndex++];
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < 9; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }
}

