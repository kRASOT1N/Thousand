package com.kras0t1n.thousand;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {
    private List<Player> players;
    private LinearLayout playersContainer;
    private TextView gameInfoTextView;
    private Button newGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Инициализация игроков
        players = new ArrayList<>();
        players.add(new Player("Player 1") {
            @Override
            public List<String> chooseCardsToPlay() {
                return null;
            }

            @Override
            public int placeBet(int maxBet) {
                return 0;
            }
        });
        players.add(new Player("Player 2") {
            @Override
            public List<String> chooseCardsToPlay() {
                return null;
            }

            @Override
            public int placeBet(int maxBet) {
                return 0;
            }
        });
        players.add(new Player("Player 3") {
            @Override
            public List<String> chooseCardsToPlay() {
                return null;
            }

            @Override
            public int placeBet(int maxBet) {
                return 0;
            }
        });

        // Находим все элементы в layout
        playersContainer = findViewById(R.id.playersContainer);
        gameInfoTextView = findViewById(R.id.gameInfoTextView);
        newGameButton = findViewById(R.id.newGameButton);

        // Назначаем слушателя на кнопку "Новая игра"
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });

        // Отображаем информацию о текущей игре
        displayGameInfo();
        // Отображаем карты игроков
        displayPlayersCards();
    }

    private void startNewGame() {
        // Очищаем информацию о текущей игре и карты игроков
        clearGameInfo();
        clearPlayersCards();

        // Перезаполняем карты игроков новыми случайными значениями
        for (Player player : players) {
            List<String> randomCards = generateRandomCards(); // Генерируем случайные карты для каждого игрока
            player.setCards(randomCards); // Устанавливаем сгенерированные карты игроку
        }

        // Отображаем информацию о текущей игре и карты игроков
        displayGameInfo();
        displayPlayersCards();
    }

    private void clearGameInfo() {
        // Очищаем информацию о текущей игре (можете изменить на свою логику)
        gameInfoTextView.setText("");
    }

    private void clearPlayersCards() {
        // Очищаем отображение карт игроков
        playersContainer.removeAllViews();
    }

    private List<String> generateRandomCards() {
        // Генерируем и возвращаем случайные карты для игрока (можете изменить на свою логику)
        List<String> randomCards = new ArrayList<>();
        // Добавляем случайные карты в список
        for (int i = 0; i < 6; i++) {
            String card = getRandomCard();
            randomCards.add(card);
        }
        return randomCards;
    }

    private String getRandomCard() {
        // Возвращает случайную карту (можете изменить на свою логику)
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        Random random = new Random();
        String suit = suits[random.nextInt(suits.length)];
        String rank = ranks[random.nextInt(ranks.length)];
        return rank + " of " + suit;
    }


    private void displayGameInfo() {
        // Выводим информацию о текущей игре (может быть заменено на вашу логику)
        gameInfoTextView.setText("Информация о текущей игре");
    }

    private void displayPlayersCards() {
        // Отображаем карты игроков (может быть заменено на вашу логику)
        playersContainer.removeAllViews();
        for (Player player : players) {
            TextView playerInfo = new TextView(this);
            playerInfo.setText(player.getName() + ": " + player.getCardsAsString());
            playersContainer.addView(playerInfo);
        }
    }
}