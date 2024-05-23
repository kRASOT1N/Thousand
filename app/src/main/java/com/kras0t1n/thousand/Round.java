package com.kras0t1n.thousand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Round {
    private List<Player> players;
    private List<String> deck;
    private Map<Player, Integer> bets;

    public Round(List<Player> players) {
        this.players = players;
        this.deck = new ArrayList<>();
        this.bets = new HashMap<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Создаем колоду карт
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
    }

    public void shuffleDeck() {
        // Перемешиваем колоду
        Collections.shuffle(deck);
    }

    public void dealCards() {
        // Раздаем карты игрокам
        int numPlayers = players.size();
        int cardsPerPlayer = deck.size() / numPlayers;

        for (int i = 0; i < numPlayers; i++) {
            Player player = players.get(i);
            List<String> playerCards = new ArrayList<>(deck.subList(i * cardsPerPlayer, (i + 1) * cardsPerPlayer));
            player.setCards(playerCards);
        }
    }

    public void placeBet(Player player, int bet) {
        bets.put(player, bet);
    }

    public void evaluateRound() {
        // Оцениваем раунд, определяем победителя и т.д.
        // В данном примере, просто выводим карты игроков
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getCardsAsString());
        }
    }

    public Map<Player, Integer> getBets() {
        return bets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        // Здесь реализуйте логику определения победителя
        // Возвращайте игрока с наибольшим количеством очков или null, если нет победителя
        return null;
    }
}
