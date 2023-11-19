package ticketbookingsystem;

/**
 * This class represents a game ticket in the ticket booking system.
 * It extends the Ticket class and inherits its properties and methods.
 * Authors: Sophie and Edward
 */
public class GameTicket extends Ticket {
    private final Game game; // The game for which the ticket is
    private final Seat seat; // The seat of the ticket
    private final String customerName; // The name of the customer

    /**
     * Constructor for the GameTicket class.
     * 
     * @param ticketId The ID of the ticket.
     * @param game The game for which the ticket is.
     * @param seat The seat of the ticket.
     * @param customerName The name of the customer.
     */
    public GameTicket(String ticketId, Game game, Seat seat, String customerName) {
        super(ticketId, game.getPrice()); // Call the constructor of the superclass, Ticket
        this.game = game;
        this.seat = seat;
        this.customerName = customerName;
    }

    /**
     * Getter method for the game of the ticket.
     * 
     * @return The game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Getter method for the seat of the ticket.
     * 
     * @return The seat.
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Getter method for the customer's name.
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
        System.out.println("Game: " + game.getGameId());
        System.out.println("Seat: " + seat.getSeatNumber());
        System.out.println("Customer: " + customerName);
        System.out.println("Status: " + getStatus());
    }
}