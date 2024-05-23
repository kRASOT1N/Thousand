package com.kras0t1n.thousand;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Games {
    private List<Player> players;
    private List<String> deck;

    public Games(List<Player> players) {
        this.players = players;
        this.deck = new ArrayList<>();
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

    public List<Player> getPlayers() {
        return players;
    }
}
