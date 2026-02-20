import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public static void main(String[] args) {
    new BlackjackGame().start();
}

public class Card {
    private final String name;
    private final int value;

    public Card(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name; // Теперь карту можно просто напечатать
    }
}

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"крести", "треф", "буби", "пики"};
        String[] ranks = {"шесть", "семь", "восемь", "девять", "десять", "король", "дама", "валет", "туз"};
        int[] values = {6, 7, 8, 9, 10, 4, 3, 2, 11}; // Исправил Туз на 11 (классика 21)

        // Автоматическое заполнение колоды вместо ручного ввода 36 строк
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(ranks[i] + " " + suit, values[i]));
            }
        }
        // Перемешиваем колоду сразу — это избавляет от сложных циклов с Random позже
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) return null;
        return cards.remove(0); // Берем верхнюю карту и удаляем её из колоды
    }
}

public class BlackjackGame {
    private final Deck deck = new Deck();
    private final Scanner scanner = new Scanner(System.in);
    private int totalScore = 0;

    public void start() {
        // Начальная раздача: две карты
        drawNextCard();
        drawNextCard();

        while (totalScore < 21) {
            System.out.println("Ваши очки: " + totalScore + ". Хотите ещё? (y/n)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("y")) {
                drawNextCard();
            } else {
                break;
            }
        }

        checkResult();
    }

    private void drawNextCard() {
        Card card = deck.drawCard();
        if (card != null) {
            totalScore += card.getValue();
            System.out.println("Выпало: " + card);
        }
    }

    private void checkResult() {
        System.out.println("Итог: " + totalScore);
        if (totalScore == 21) {
            System.out.println("ТЫ выиграл!");
        } else if (totalScore > 21) {
            System.out.println("Ты проиграл (Перебор)!");
        } else {
            System.out.println("Вы остановились на " + totalScore);
        }
    }
}