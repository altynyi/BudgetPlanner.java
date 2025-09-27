import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Shop with a catalog of items.
 */
public class Shop {

    private static class Item {
        private String name;
        private int price;
        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }
        public String getName() { return name; }
        public int getPrice() { return price; }
    }

    private List<Item> items;

    /**
     * Constructs a Shop and sets up the item catalog.
     */
    public Shop() {
        items = new ArrayList<>();
        items.add(new Item("Sword", 100));
        items.add(new Item("Health Potion", 25));
        items.add(new Item("Armor", 150));
    }

    /**
     * Prints the catalog of items.
     */
    public void printCatalog() {
        System.out.println("--- Catalog ---");
        System.out.println("Index | Name          | Price");
        System.out.println("-----------------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" %-4d | %-13s | %4d Gold%n", i + 1, items.get(i).getName(), items.get(i).getPrice());
        }
        System.out.println("---------------");
    }

    /**
     * Lets the hero buy an item by index.
     */
    public void sell(Hero hero, int itemIndex) {
        int actualIndex = itemIndex - 1;

        if (actualIndex < 0 || actualIndex >= items.size()) {
            System.out.println("Invalid item index.");
            return;
        }

        Item itemToSell = items.get(actualIndex);
        int itemPrice = itemToSell.getPrice();

        if (hero.getGold() >= itemPrice) {
            hero.setGold(hero.getGold() - itemPrice);
            hero.addItem(itemToSell.getName()); // Assuming Hero has this method
            System.out.printf("%s bought a %s for %d Gold. %d Gold remains.\n", 
                              hero.getName(), itemToSell.getName(), itemPrice, hero.getGold());
        } else {
            System.out.printf("%s doesn't have enough Gold for %s (Need %d).\n", 
                              hero.getName(), itemToSell.getName(), itemPrice);
        }
    }

    // --- Minimal Hero Class for compilation/testing ---

    /**
     * Minimal Hero class to support the sell method's functionality.
     */
    public static class Hero {
        private String name;
        private int gold;
        private List<String> inventory = new ArrayList<>();

        public Hero(String name, int gold) { this.name = name; this.gold = gold; }
        public String getName() { return name; }
        public int getGold() { return gold; }
        public void setGold(int gold) { this.gold = gold; }
        public void addItem(String itemName) { inventory.add(itemName); }
    }

    // --- Demonstration ---

    public static void main(String[] args) {
        Shop shop = new Shop();
        Hero player = new Hero("PlayerOne", 120);

        shop.printCatalog();
        
        shop.sell(player, 1); // Buy Sword (100 Gold)
        shop.sell(player, 2); // Try to buy Potion (25 Gold) - Fails (120 - 100 = 20 Gold left)
    }
}
