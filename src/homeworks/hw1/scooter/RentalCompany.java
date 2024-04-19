package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a rental company that manages a fleet of scooters.
 */
public class RentalCompany {

    private int uid = 0;

    private List<Scooter> scooters = new ArrayList<>();

    /**
     * Returns a list of available scooters.
     *
     * @return List of available scooters
     */
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter : scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    /**
     * Adds a scooter to the rental company's fleet.
     *
     * @param scooter The scooter to be added
     */
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    /**
     * Removes a scooter from the rental company's fleet based on its ID.
     *
     * @param id The ID of the scooter to be removed
     * @return true if the scooter is successfully removed, false otherwise
     */
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents a scooter based on its ID.
     *
     * @param id The ID of the scooter to be rented
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && scooter.isAvailable()) {
                scooter.setAvailable(false);
                break;
            }
        }
    }

    /**
     * Returns a rented scooter to the rental company, updating its position.
     *
     * @param id The ID of the scooter to be returned
     * @param x  The new X-coordinate of the scooter's position
     * @param y  The new Y-coordinate of the scooter's position
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && !scooter.isAvailable()) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                break;
            }
        }
    }

    /**
     * Displays information about all scooters in the rental company's fleet.
     */
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter.toString());
        }
    }
}
