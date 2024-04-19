package homeworks.hw1.scooter;

import java.util.Random;

/**
 * A class to test the scooter rental scenario.
 */
public class ScooterRentalTester {

    public static void main(String[] args) {
        // Create a rental company
        RentalCompany rentalCompany = new RentalCompany();

        // Add a scooter to the rental company's fleet
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setModel("Scooty X1");
        scooter.setBatteryLevel(100);
        scooter.setX(getRandomCoordinate()); // Home X coordinate
        scooter.setY(getRandomCoordinate()); // Home Y coordinate
        scooter.setAvailable(true);
        rentalCompany.addScooter(scooter);

        // Display available scooters before renting
        System.out.println("Available Scooters:");
        rentalCompany.displayAllScooters();

        // Rent the scooter
        rentalCompany.rentScooter(1);

        // Simulate traveling from home to the university
        double universityX = getRandomCoordinate(); // University X coordinate
        double universityY = getRandomCoordinate(); // University Y coordinate
        scooter.setX(universityX);
        scooter.setY(universityY);

        // Display available scooters after renting
        System.out.println("\nAvailable Scooters after renting:");
        rentalCompany.displayAllScooters();

        // Simulate leaving the scooter at the university
        // Assuming waiting for one hour
        try {
            Thread.sleep(3600000); // Wait for one hour (in milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rent the scooter again after one hour
        rentalCompany.rentScooter(1);

        // Simulate returning from the university to home
        double homeX = getRandomCoordinate(); // Home X coordinate
        double homeY = getRandomCoordinate(); // Home Y coordinate
        scooter.setX(homeX);
        scooter.setY(homeY);

        // Display available scooters after returning
        System.out.println("\nAvailable Scooters after returning:");
        rentalCompany.displayAllScooters();
    }

    // Method to generate random coordinates
    private static double getRandomCoordinate() {
        // Generating random coordinates within a range (e.g., 0 to 100)
        Random random = new Random();
        return random.nextDouble() * 100;
    }
}
