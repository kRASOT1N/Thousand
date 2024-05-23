package com.kras0t1n.thousand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    // Конструктор
    public Deck() {
        this.cards = new ArrayList<>();
        String[] suits = {"hearts", "diamonds", "clubs", "spades"};
        String[] ranks = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    // Геттеры и сеттеры
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    // Метод для перемешивания колоды
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Метод для раздачи карт
    public Card dealCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
}