import java.util.*;

public class HeroGame {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    static String name;
    static int coins = 0;
    static int energy = 10;
    static List<String> inventory = new ArrayList<>();

    static Map<String, Integer> shop = new LinkedHashMap<>();

    public static void main(String[] args) {
        shop.put("Bread", 5);
        shop.put("Potion", 10);
        shop.put("Shield", 20);
        shop.put("Magic Ring", 30);
        shop.put("Sword of Victory", 50);

        System.out.print("Enter hero's name: ");
        name = scanner.nextLine();

        System.out.println("Welcome to the Hero Mini-Game!");
        showShop();

        // Main game loop
        while (true) {
            System.out.println();
            showStatus();
            System.out.print("> ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    run();
                    break;
                case "2":
                    work();
                    break;
                case "3":
                    rest();
                    break;
                case "4":
                    buy();
                    break;
                case "5":
                    showInventory();
                    break;
                default:
                    System.out.println("Invalid action.");
            }

            if (checkVictory()) {
                System.out.println("\n🎉 " + name + " has obtained the Sword of Victory and at least 2 other items!");
                System.out.println("🏆 Victory Achieved!");
                break;
            }
        }
    }

    static void showShop() {
        System.out.println("=== 🛒 Shop Catalog ===");
        for (Map.Entry<String, Integer> entry : shop.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " coins");
        }
        System.out.println();
    }

    static void showStatus() {
        System.out.println("=== Hero Status ===");
        System.out.println("Name: " + name + " | Coins: " + coins + " | Energy: " + energy);
        System.out.println("Inventory: " + inventory);
        System.out.println("Choose action:\n1=Run  2=Work  3=Rest  4=Buy  5=Inventory");
    }

    static void run() {
        if (energy <= 0) {
            System.out.println("Too tired to run!");
            return;
        }
        int loss = rand.nextInt(3) + 1;
        if (energy < loss) {
            System.out.println("Not enough energy to run (-" + loss + " needed).");
            return;
        }
        int gain = rand.nextInt(11) + 5; // 5 to 15
        coins += gain;
        energy -= loss;
        System.out.println(name + " ran swiftly: +" + gain + " coins, -" + loss + " energy");
    }

    static void work() {
        if (energy < 2) {
            System.out.println("Too tired to work!");
            return;
        }
        coins += 10;
        energy -= 2;
        System.out.println(name + " worked hard: +10 coins, -2 energy");
    }

    static void rest() {
        int gain = rand.nextInt(4) + 2; // 2 to 5
        energy += gain;
        System.out.println(name + " took a rest: +" + gain + " energy");
    }

    static void buy() {
        System.out.println("What do you want to buy?");
        int index = 1;
        List<String> items = new ArrayList<>(shop.keySet());
        for (String item : items) {
            System.out.println(index + ". " + item + " - " + shop.get(item) + " coins");
            index++;
        }
        System.out.print("> ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > items.size()) {
                System.out.println("Invalid choice.");
                return;
            }
            String item = items.get(choice - 1);
            int price = shop.get(item);
            if (inventory.contains(item)) {
                System.out.println("Already owns " + item + ".");
            } else if (coins >= price) {
                coins -= price;
                inventory.add(item);
                System.out.println(name + " bought " + item + "!");
            } else {
                System.out.println("Not enough coins!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    static void showInventory() {
        System.out.println("=== Inventory ===");
        System.out.println(inventory);
    }

    static boolean checkVictory() {
        return inventory.contains("Sword of Victory") && inventory.size() >= 3;
    }
}

