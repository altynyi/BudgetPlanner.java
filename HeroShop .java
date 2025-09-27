/*You can find items and their prices in previous example "task 1" BudgetPlanner*/
public class HeroShop {
    public static void main(String[] args) {
        int coins = 42;

        String[] items = {"bread", "potion", "sword"};
        for (String item : items) {
            System.out.println("Trying to buy: " + item);
            System.out.println(tryPurchase(item, coins));
            System.out.println(); // Line break
        }
    }

    public static String tryPurchase(String item, int coins) {
        int price;

        switch (item) {
            case "bread":
                price = 5;
                break;
            case "potion":
                price = 12;
                break;
            case "sword":
                price = 50;
                break;
            default:
                return "Item not found";
        }

        if (coins < price) {
            return "Not enough";
        } else if (coins == price) {
            return "Enough for exact purchase";
        } else {
            if (coins >= 2 * price) {
                double discountedPrice = price * 0.8;
                if (coins >= discountedPrice) {
                    return String.format("Discount applied! You can buy the %s for %.2f coins.", item, discountedPrice);
                } else {
                    return "Not enough (even with discount)";
                }
            } else {
                return String.format("You can buy the %s without a discount.", item);
            }
        }
    }
}

