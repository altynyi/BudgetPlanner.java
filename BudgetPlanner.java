public class BudgetPlanner {

    public static void main(String[] args) {
        String heroName = "Alex";
        int heroCoins = 42;

        String item1Name = "Bread";
        int item1Price = 5;
        
        String item2Name = "Potion";
        int item2Price = 12;

        String item3Name = "Sword";
        int item3Price = 50;
        int canBuy1 = heroCoins / item1Price;
        int canBuy2 = heroCoins / item2Price;
        int canBuy3 = heroCoins / item3Price;

        System.out.println("Hero: " + heroName + ", Coins: " + heroCoins);

        System.out.printf("%-7s | %5s | %7s%n", "Item", "Price", "Can Buy");
     
        System.out.println("--------+-------+--------");

        System.out.printf("%-7s | %5d | %6d%n", item1Name, item1Price, canBuy1);
        System.out.printf("%-7s | %5d | %6d%n", item2Name, item2Price, canBuy2);
        System.out.printf("%-7s | %5d | %6d%n", item3Name, item3Price, canBuy3);
    }
}
