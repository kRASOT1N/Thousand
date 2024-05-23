package com.kras0t1n.thousand;

import java.util.List;

public class Card {
    private String suit; // "hearts", "diamonds", "clubs", "spades"
    private String rank; // "6", "7", "8", "9", "10", "J", "Q", "K", "A"

    // Конструктор
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Геттеры и сеттеры
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}