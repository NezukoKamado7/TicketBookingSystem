package ticketbookingsystem;

/**
 * This class represents a show ticket in the ticket booking system.
 * It extends the Ticket class and inherits its properties and methods.
 * Authors: Sophie and Edward
 */
public class ShowTicket extends Ticket {
    private final Show show;            // The show for which the ticket is
    private final Seat seat;            // The seat of the ticket
    private final String customerName;  // The name of the customer

    /**
     * Constructor for the ShowTicket class.
     *
     * @param ticketId      The ID of the ticket.
     * @param show          The show for which the ticket is.
     * @param seat          The seat of the ticket.
     * @param customerName  The name of the customer.
     */
    public ShowTicket(String ticketId, Show show, Seat seat, String customerName) {
        super(ticketId, show.getPrice()); // Call the constructor of the superclass, Ticket
        this.show = show;
        this.seat = seat;
        this.customerName = customerName;
    }

    /**
     * Retrieves the show of the ticket.
     *
     * @return The show.
     */
    public Show getShow() {
        return show;
    }

    /**
     * Retrieves the seat of the ticket.
     *
     * @return The seat.
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Retrieves the customer's name.
     *
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
        System.out.println("Show: " + show.getShowId());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Customer: " + customerName);
        System.out.println("Status: " + getStatus());
    }
}