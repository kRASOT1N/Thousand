package com.kras0t1n.thousand;

import java.util.ArrayList;
import java.util.List;


public abstract class Player {
    private String name;
    private List<String> cards;
    private int score;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>(); // Инициализация списка карт при создании объекта
    }

    public List<String> getCards() {
        return cards;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public String getCardsAsString() {
        StringBuilder sb = new StringBuilder();
        for (String card : cards) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }

    // Переопределяем метод для принятия решения о картах, которые будет играть бот
    public abstract List<String> chooseCardsToPlay();

    // Переопределяем метод для принятия решения о ставке
    public abstract int placeBet(int maxBet);
}
