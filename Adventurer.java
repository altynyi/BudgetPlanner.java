import java.util.*;

public class HeroGame {

    static class Adventurer {
        String name;
        int coins = 0, items = 0;
        Random rand = new Random();

        Adventurer(String name) {
            this.name = name;
        }

        void act() {
            switch (rand.nextInt(4)) {
                case 0 -> System.out.println(name + " runs.");
                case 1 -> {
                    int earned = rand.nextInt(11) + 5;
                    coins += earned;
                    System.out.println(name + " works and earns " + earned + " coins.");
                }
                case 2 -> System.out.println(name + " rests.");
                case 3 -> {
                    if (coins >= 10) {
                        coins -= 10;
                        items++;
                        System.out.println(name + " buys an item.");
                    } else {
                        System.out.println(name + " tries to buy but lacks coins.");
                    }
                }
            }
        }

        int score() {
            return items * 10 + coins;
        }
    }

    public static void main(String[] args) {
        Adventurer a1 = new Adventurer("Mila");
        Adventurer a2 = new Adventurer("Zane");

        for (int i = 1; i <= 10; i++) {
            System.out.println("--- Round " + i + " ---");
            a1.act();
            a2.act();
            System.out.println();
        }

        System.out.printf("%s: %d items, %d coins%n", a1.name, a1.items, a1.coins);
        System.out.printf("%s: %d items, %d coins%n", a2.name, a2.items, a2.coins);

        if (a1.score() > a2.score()) {
            System.out.printf("Winner: %s with %d items and %d coins!%n", a1.name, a1.items, a1.coins);
        } else if (a2.score() > a1.score()) {
            System.out.printf("Winner: %s with %d items and %d coins!%n", a2.name, a2.items, a2.coins);
        } else {
            System.out.println("It's a tie!");
        }
    }
}

