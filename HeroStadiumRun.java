import java.util.Random;

public class HeroStadiumRun {

    public static void main(String[] args) {
        // Constants and Initial Values
        final int STARTING_ENERGY = 20;
        final int BONUS_LAP = 5;
        final int BOOST_AMOUNT = 2;

        int currentEnergy = STARTING_ENERGY;
        int lapCount = 0;

        // Initialize the Random object for energy consumption
        Random random = new Random();

        // Print the starting state
        System.out.println("The hero starts with " + STARTING_ENERGY + " energy.");
        System.out.println("-------------------------------------------------");

        // Loop as long as the hero has energy
        while (currentEnergy > 0) {
            lapCount++;
            int energyConsumption;

            // 1. Calculate energy consumption (random 1-3)
            // nextInt(bound) returns a value from 0 (inclusive) to bound (exclusive).
            // random.nextInt(3) returns 0, 1, or 2. We add 1 to get 1, 2, or 3.
            energyConsumption = random.nextInt(3) + 1;
            
            // Apply the consumption
            currentEnergy -= energyConsumption;

            // 2. Check for the Adrenaline Boost (every 5th lap)
            if (lapCount % BONUS_LAP == 0) {
                currentEnergy += BOOST_AMOUNT;
                
                // Print the lap result with the boost
                System.out.printf("Lap %-3d | Adrenaline boost! +%d energy | Energy left: %d%n", 
                                  lapCount, BOOST_AMOUNT, currentEnergy);
            } else {
                // Print the standard lap result
                System.out.printf("Lap %-3d | -%d energy | Energy left: %d%n", 
                                  lapCount, energyConsumption, currentEnergy);
            }
        }

        // Final output
        System.out.println("-------------------------------------------------");
        System.out.println("The hero has run out of energy on lap " + lapCount + ".");
        System.out.println("Total laps completed: " + (lapCount - 1));
    }
}
