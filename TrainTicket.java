package ticketbookingsystem;

import java.util.Date;

/**
 * This class represents a train ticket in the ticket booking system.
 * It extends the Ticket class and inherits its properties and methods.
 * Authors: Sophie and Edward
 */
public class TrainTicket extends Ticket {
    private final Train train; // The train for which the ticket is
    private final Seat seat; // The seat of the ticket
    private final String customerName; // The name of the customer
    private final String berthType; // The type of the berth (Upper or Lower)

    /**
     * Constructor for the TrainTicket class.
     * @param ticketId The ID of the ticket.
     * @param train The train for which the ticket is.
     * @param seat The seat of the ticket.
     * @param customerName The name of the customer.
     * @param berthType The type of the berth (Upper or Lower).
     */
    public TrainTicket(String ticketId, Train train, Seat seat, String customerName, String berthType) {
        super(ticketId, train.getPrice()); // Call the constructor of the superclass, Ticket
        this.train = train;
        this.seat = seat;
        this.customerName = customerName;
        this.berthType = berthType;
    }

    /**
     * Getter method for the train of the ticket.
     * @return The train.
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Getter method for the seat of the ticket.
     * @return The seat.
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Getter method for the berth type of the ticket.
     * @return The berth type of the ticket.
     */
    public String getBerthType() {
        return berthType;
    }

    /**
     * Getter method for the customer's name.
     * @return The customer's name.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Method to print the details of the ticket.
     * This method is required because it is declared as abstract in the Ticket class.
     */
    @Override
    public void printTicketDetails() {
        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Train: " + train.getTrainId());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Berth Type: " + berthType);
        System.out.println("Customer: " + customerName);
        System.out.println("Status: " + getStatus());
    }

    /**
     * Method to print the boarding pass for the ticket. If the ticket is booked, it prints all the details.
     * If the ticket is not booked, it prints a failure message.
     */
    public void printBoardingPass() {
        if(getStatus().equals("Booked")) {
            System.out.println("Date: " + new Date().toString());
            System.out.println("Boarding pass for ticket ID: " + getTicketId());
            System.out.println("Train: " + train.getTrainId());
            System.out.println("Seat: " + seat.getSeatNumber());
            System.out.println("Berth Type: " + berthType);
            System.out.println("Customer: " + customerName);
            System.out.println("Unfortunately, this ticket is non-refundable.");
            System.out.println("Please be thoughtful, considerate and clean up after yourself when you are done. Have a wonderful trip.");
        } else {
            System.out.println("Ticket " + getTicketId() + " for train " + train.getTrainId() + " has not been booked.");
        }
    }
}