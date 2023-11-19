package ticketbookingsystem;

/**
 * This is an abstract class that represents a generic ticket.
 * The Ticket class provides basic functionality such as booking and cancelling a ticket.
 * It's an abstract class because it doesn't make sense to instantiate a general Ticket.
 * Instead, you'll create instances of its subclasses, such as ShowTicket, TrainTicket, or GameTicket.
 * Authors: Sophie and Edward
 */
public abstract class Ticket {

    protected String ticketId;   // The ID of the ticket
    protected double price;      // The price of the ticket
    protected String status;     // The status of the ticket

    /**
     * Constructor for the Ticket class.
     *
     * @param ticketId The ID of the ticket.
     * @param price    The price of the ticket.
     */
    public Ticket(String ticketId, double price) {
        this.ticketId = ticketId;
        this.price = price;
        this.status = "Available";   // Initialize status of the ticket to "Available".
    }

    /**
     * Retrieves the ID of the ticket.
     *
     * @return The ticket ID.
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Retrieves the price of the ticket.
     *
     * @return The ticket price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the status of the ticket.
     *
     * @return The ticket status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method to book the ticket.
     * If the ticket is already booked, print an error message.
     * Otherwise, change the status of the ticket to "Booked" and print a success message.
     */
    public void book() {
        if (status.equals("Available")) {
            status = "Booked";
            System.out.println("Ticket " + ticketId + " booked successfully.");
        } else {
            System.out.println("Ticket " + ticketId + " is already booked.");
        }
    }

    /**
     * Method to cancel the ticket.
     * If the ticket is already available, print an error message.
     * Otherwise, change the status of the ticket to "Available" and print a success message.
     */
    public void cancel() {
        if (status.equals("Booked")) {
            status = "Available";
            System.out.println("Ticket " + ticketId + " cancelled successfully.");
        } else {
            System.out.println("Ticket " + ticketId + " is already available.");
        }
    }

    /**
     * Abstract method to print specific details of the ticket.
     */
    public abstract void printTicketDetails();
}