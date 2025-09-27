public class Sword_Savings_Calculator {

    public static void main(String[] args) {
        final int SWORD_COST = 50;
        final int MONTHLY_EARNING = 7;
        final int BONUS_AMOUNT = 10;
        final int BONUS_FREQUENCY = 4; // Every 4th month

        int totalCoins = 0;
        int month = 0;

        System.out.println("Month | Coins total");
        System.out.println("------+------------");

        while (totalCoins < SWORD_COST) {
            month++;
            int earningsThisMonth = MONTHLY_EARNING;

            // Check for the bonus month
            if (month % BONUS_FREQUENCY == 0) {
                earningsThisMonth += BONUS_AMOUNT;
            }
            totalCoins += earningsThisMonth;

            
            System.out.printf("%-5d | %d%n", month, totalCoins);
        }

        System.out.println("\nAlex needs " + month + " months to buy the sword.");
    }
}
