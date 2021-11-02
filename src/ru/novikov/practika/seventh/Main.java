package ru.novikov.practika.seventh;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        int[] randomDictionary = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Init array
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заполнять рандомом? (true - да, false - нет)");
        boolean isRandom = scanner.nextBoolean();
        if (isRandom) {
            for (int i = 0; i < array.length; i++) {
                int randomIndex = (int) (Math.random() * 10);
                if (randomDictionary[randomIndex] == -1) {
                    randomIndex = getIndexThatNotMinusOne(randomDictionary);
                }
                array[i] = randomDictionary[randomIndex];
                randomDictionary[randomIndex] = -1;
            }
            System.out.println("Заданная последовательность: " + Arrays.toString(array));
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("Введённая последовательность: " + Arrays.toString(array));
        }
        Stack<Integer> stack = new Stack<>();
        DrunkGame drunkGame = new DrunkGame(array);
        drunkGame.startGame();
        switch (drunkGame.getResult()) {
            case 1 -> System.out.println("Выйграл первый игрок! Ходов: " + drunkGame.getCount());
            case 2 -> System.out.println("Выйграл второй игрок! Ходов: " + drunkGame.getCount());
            case 3 -> System.out.println("Ботва!");
        }
    }

    private static int getIndexThatNotMinusOne(int[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}
