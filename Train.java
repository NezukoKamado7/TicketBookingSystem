package ticketbookingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a train in the ticket booking system.
 * Authors: Sophie and Edward
 */
public class Train {
    private final String trainId; // The ID of the train
    private final String name; // The name of the train
    private final Venue venue; // The venue of the train
    private final double price; // The price of the train
    private final ArrayList<Seat> seats; // The seats of the train

    /**
     * Constructor for the Train class.
     * @param trainId The ID of the train.
     * @param name The name of the train.
     * @param venue The venue of the train.
     * @param price The price of the train.
     */
    public Train(String trainId, String name, Venue venue, double price) {
        this.trainId = trainId;
        this.name = name;
        this.venue = venue;
        this.price = price;
        this.seats = new ArrayList<>();   // Initialize the list of seats.
    }

    /**
     * Getter method for the train ID.
     * @return The train ID.
     */
    public String getTrainId() {
        return trainId;
    }

    /**
     * Getter method for the price of the train.
     * @return The price of the train.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Method to add a seat to the train.
     * 
     * @param seat The seat to be added.
     */
    public void addSeat(Seat seat) {
        seats.add(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " added to train " + trainId);
    }

    /**
     * Method to remove a seat from the train.
     * 
     * @param seat The seat to be removed.
     */
    public void removeSeat(Seat seat) {
        seats.remove(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " removed from train " + trainId);
    }

    /**
     * Method to get the list of available seats in the train.
     * 
     * @return The list of available seats.
     */
    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for(Seat seat : seats) {
            if(seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    /**
     * Retrieves the seats in the train.
     * 
     * @return An iterable of seats in the train.
     */
    public Iterable<Seat> getSeats() {
        return seats;
    }
}