import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero2 {
    // --- Fields ---
    private String name;
    private int coins;
    private double energy;
    private List<String> inventory;
    
    private static final int MAX_ENERGY = 20; 
    private static final Random RANDOM = new Random(); 

    // --- Constructor ---
    public Hero2(String name, int coins, double energy) {
        this.name = name;
        this.coins = coins;
        this.energy = Math.min(energy, MAX_ENERGY); 
        this.inventory = new ArrayList<>();
    }

    // --- Methods ---

    /** Prints a formatted table showing the hero's current status. */
    public void printStatus() {
        System.out.println("\n==================================");
        System.out.println("          HERO STATUS");
        System.out.println("==================================");
        System.out.printf("| %-10s | %-16s |\n", "Attribute", "Value");
        System.out.println("----------------------------------");
        System.out.printf("| %-10s | %-16s |\n", "Name", this.name);
        System.out.printf("| %-10s | %-16d |\n", "Coins", this.coins);
        System.out.printf("| %-10s | %-16.2f |\n", "Energy", this.energy);
        System.out.printf("| %-10s | %-16s |\n", "Inventory", this.inventory.size() + " items");
        System.out.println("==================================");
        if (!inventory.isEmpty()) {
            System.out.println("Inventory Contents: " + String.join(", ", inventory));
        }
    }

    /** Adds an item to the inventory. */
    public void addItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            this.inventory.add(item);
        }
    }

    /** Returns true if the item is in the inventory (case-insensitive). */
    public boolean hasItem(String item) {
        if (item == null) return false;
        for (String existingItem : this.inventory) {
            if (existingItem.equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }

    /** Consumes 1–3 random energy. */
    public void run() {
        int energyConsumed = RANDOM.nextInt(3) + 1; 
        if (this.energy >= energyConsumed) {
            this.energy -= energyConsumed;
            System.out.printf("%s ran, consumed %d energy.\n", this.name, energyConsumed);
        } else {
            System.out.println(this.name + " is too tired to run.");
        }
    }

    /** +10 coins, −2 energy. */
    public void work() {
        final double energyCost = 2.0;
        if (this.energy >= energyCost) {
            this.coins += 10;
            this.energy -= energyCost;
            System.out.println(this.name + " worked: +10 coins, -2 energy.");
        } else {
            System.out.println(this.name + " is too tired to work.");
        }
    }

    /** +5 energy (max 20). */
    public void rest() {
        double oldEnergy = this.energy;
        this.energy = Math.min(this.energy + 5.0, MAX_ENERGY);
        if (this.energy > oldEnergy) {
            System.out.printf("%s rested: +%.2f energy.\n", this.name, (this.energy - oldEnergy));
        } else {
            System.out.println(this.name + " is fully rested.");
        }
    }

    /** Purchase item if coins ≥ price and add to inventory. */
    public void buy(String item, int price) {
        if (price < 0) return;
        
        if (this.coins >= price) {
            this.coins -= price;
            this.inventory.add(item);
            System.out.printf("%s bought %s for %d coins.\n", this.name, item, price);
        } else {
            System.out.printf("%s cannot afford %s (Need %d).\n", this.name, item, price);
        }
    }

    // --- Simple Demo (for execution) ---
    public static void main(String[] args) {
        Hero demoHero = new Hero("Kael", 50, 15.0);
        demoHero.printStatus();
        demoHero.work();
        demoHero.run();
        demoHero.buy("Iron Shield", 30);
        demoHero.rest();
        demoHero.printStatus();
        System.out.println("Has 'Iron Shield'? " + demoHero.hasItem("Iron Shield"));
    }
}
