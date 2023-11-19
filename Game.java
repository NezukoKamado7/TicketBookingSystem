package ticketbookingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a game in the ticket booking system.
 * Authors: Sophie and Edward
 */
public class Game {
    private final String gameId; // The ID of the game
    private final String name; // The name of the game
    private final Venue venue; // The venue of the game
    private final double price; // The price of the game
    private final ArrayList<Ticket> tickets; // The tickets of the game
    private final ArrayList<Seat> seats; // The seats of the game

    /**
     * Constructor for the Game class.
     * @param gameId The ID of the game.
     * @param name The name of the game.
     * @param venue The venue of the game.
     * @param price The price of the game.
     */
    public Game(String gameId, String name, Venue venue, double price) {
        this.gameId = gameId;
        this.name = name;
        this.venue = venue;
        this.price = price;
        this.tickets = new ArrayList<>();   // Initialize the list of tickets.
        this.seats = new ArrayList<>();   // Initialize the list of seats.
    }

    /**
     * Getter method for the game ID.
     * @return The game ID.
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Getter method for the price of the game.
     * @return The price of the game.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the name of the game.
     * 
     * @return The name of the game.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the venue of the game.
     * 
     * @return The venue of the game.
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Adds a ticket to the game.
     * 
     * @param ticket The ticket to be added.
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket " + ticket.getTicketId() + " incorporated to the game " + gameId);
    }

    /**
     * Removes a ticket from the game.
     * 
     * @param ticket The ticket to be removed.
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        System.out.println("Ticket " + ticket.getTicketId() + " removed from the game " + gameId);
    }

    /**
     * Retrieves a list of available tickets for the game.
     * 
     * @return The list of available tickets.
     */
    public List<Ticket> getAvailableTickets() {
        List<Ticket> availableTickets = new ArrayList<>();
        for(Ticket ticket : tickets) {
            if(ticket.getStatus().equals("Available")) {
                availableTickets.add(ticket);
            }
        }
        return availableTickets;
    }

    /**
     * Method to add a seat to the game.
     * 
     * @param seat The seat to be added.
     */
    public void addSeat(Seat seat) {
        seats.add(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " added to game " + gameId);
    }

    /**
     * Method to remove a seat from the game.
     * 
     * @param seat The seat to be removed.
     */
    public void removeSeat(Seat seat) {
        seats.remove(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " removed from game " + gameId);
    }

    /**
     * Retrieves the seats in the game.
     * 
     * @return An iterable of seats in the game.
     */
    public Iterable<Seat> getSeats() {
        return seats;
    }
}