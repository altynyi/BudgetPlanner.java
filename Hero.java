import java.util.ArrayList;
import java.util.List;

public class Hero {
    // Fields
    private String name;
    private int coins;
    private double energy;
    private List<String> inventory; // Using List<String> for a resizable array

    /**
     * Constructor to initialize a Hero object.
     * @param name The name of the hero.
     * @param coins The starting number of coins.
     * @param energy The starting energy level.
     */
    public Hero(String name, int coins, double energy) {
        this.name = name;
        this.coins = coins;
        this.energy = energy;
        this.inventory = new ArrayList<>(); // Initialize the inventory as an empty list
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    /**
     * Method: printStatus()
     * Prints a formatted table showing the hero's current status.
     * (Homework #1)
     */
    public void printStatus() {
        System.out.println("\n==================================");
        System.out.println("          HERO STATUS");
        System.out.println("==================================");
        System.out.printf("| %-10s | %-16s |\n", "Attribute", "Value");
        System.out.println("----------------------------------");
        System.out.printf("| %-10s | %-16s |\n", "Name", this.name);
        System.out.printf("| %-10s | %-16d |\n", "Coins", this.coins);
        // Format energy to two decimal places
        System.out.printf("| %-10s | %-16.2f |\n", "Energy", this.energy);
        System.out.printf("| %-10s | %-16s |\n", "Inventory", this.inventory.size() + " items");
        System.out.println("==================================");
        
        // Detailed inventory listing
        if (!inventory.isEmpty()) {
            System.out.println("Inventory Contents:");
            for (String item : inventory) {
                System.out.println("  - " + item);
            }
        } else {
            System.out.println("Inventory Contents: (Empty)");
        }
        System.out.println("----------------------------------");
    }

    /**
     * Method: addItem(String item)
     * Adds an item to the hero's inventory.
     * @param item The name of the item to add.
     */
    public void addItem(String item) {
        if (item != null && !item.trim().isEmpty()) {
            this.inventory.add(item);
            System.out.println(this.name + " acquired: **" + item + "**.");
        } else {
            System.out.println("Cannot add an empty item.");
        }
    }

    /**
     * Method: hasItem(String item)
     * Checks if the hero's inventory contains the specified item.
     * @param item The name of the item to check for.
     * @return true if the item is found, false otherwise.
     */
    public boolean hasItem(String item) {
        // Checks if the inventory list contains the item, ignoring case
        if (item == null) return false;
        
        for (String existingItem : this.inventory) {
            if (existingItem.equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }


    //--------------------------------------------------
    // Example Usage (Main Method)
    //--------------------------------------------------

    public static void main(String[] args) {
        // 1. Create a Hero object
        Hero aragorn = new Hero("Aragorn", 50, 95.5);

        // 2. Add items to inventory
        aragorn.addItem("Andúril");
        aragorn.addItem("Phial of Galadriel");
        aragorn.addItem("Athelas Leaves");

        // 3. Print the hero's status
        System.out.println("--- Initial Status ---");
        aragorn.printStatus();

        // 4. Check for items
        String item1 = "Andúril";
        String item2 = "Bow";
        
        System.out.println("\n--- Item Checks ---");
        System.out.println("Does " + aragorn.name + " have '" + item1 + "'? " + aragorn.hasItem(item1));
        System.out.println("Does " + aragorn.name + " have '" + item2 + "'? " + aragorn.hasItem(item2));
        
        // 5. Update status
        aragorn.coins += 100; // Found a hidden stash
        aragorn.energy -= 10.25; // Used energy in a fight
        
        System.out.println("\n--- Updated Status ---");
        aragorn.printStatus();
    }
}
