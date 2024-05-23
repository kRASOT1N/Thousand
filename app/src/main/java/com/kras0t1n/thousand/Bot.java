package com.kras0t1n.thousand;
import java.util.List;
import java.util.Random;

public class Bot extends Player {
    private Random random;

    public Bot(String name) {
        super(name);
        random = new Random();
    }

    // Переопределяем метод для принятия решения о картах, которые будет играть бот
    @Override
    public List<String> chooseCardsToPlay() {
        // Просто выбираем случайное количество карт из руки бота
        int numCardsToPlay = random.nextInt(getCards().size()) + 1;
        return getCards().subList(0, numCardsToPlay);
    }

    // Переопределяем метод для принятия решения о ставке
    @Override
    public int placeBet(int maxBet) {
        // Просто делаем случайную ставку от 0 до максимальной возможной ставки
        return random.nextInt(maxBet + 1);
    }
}
