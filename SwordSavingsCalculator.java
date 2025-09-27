public class SwordSavingsCalculator {

    public static void main(String[] args) {
        // Constants for the problem
        final int SWORD_COST = 50;
        final int MONTHLY_EARNING = 7;
        final int BONUS_AMOUNT = 10;
        final int BONUS_FREQUENCY = 4; // Every 4th month

        // Variables for tracking progress
        int totalCoins = 0;
        int month = 0;

        // Print the table header
        System.out.println("Month | Coins total");
        System.out.println("------+------------");

        // Loop until the total coins are enough to buy the sword
        while (totalCoins < SWORD_COST) {
            month++;
            int earningsThisMonth = MONTHLY_EARNING;

            // Check for the bonus month
            if (month % BONUS_FREQUENCY == 0) {
                earningsThisMonth += BONUS_AMOUNT;
            }

            // Update the total coins
            totalCoins += earningsThisMonth;

            // Print the current row of the table
            // %-5d ensures the month number is left-justified in a 5-character space
            // %d ensures the total coins are printed
            System.out.printf("%-5d | %d%n", month, totalCoins);
        }

        // Print the final result
        System.out.println("\nAlex needs " + month + " months to buy the sword.");
    }
}
