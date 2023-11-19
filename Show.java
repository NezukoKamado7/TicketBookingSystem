package ticketbookingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a show in the ticket booking system.
 * Authors: Sophie and Edward
 */
public class Show {
    private final String showId; // The ID of the show
    private final Event event; // The event of the show
    private final Venue venue; // The venue of the show
    private final double price; // The price of the show
    private final ArrayList<Ticket> tickets; // The tickets of the show
    private final ArrayList<Seat> seats; // The seats of the show

    /**
     * Constructor for the Show class.
     * @param showId The ID of the show.
     * @param event The event of the show.
     * @param venue The venue of the show.
     * @param price The price of the show.
     */
    public Show(String showId, Event event, Venue venue, double price) {
        this.showId = showId;
        this.event = event;
        this.venue = venue;
        this.price = price;
        this.tickets = new ArrayList<>();   // Initialize the list of tickets.
        this.seats = new ArrayList<>();   // Initialize the list of seats.
    }

    /**
     * Getter method for the show ID.
     * @return The show ID.
     */
    public String getShowId() {
        return showId;
    }

    /**
     * Getter method for the price of the show.
     * @return The price of the show.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the event of the show.
     *
     * @return The event.
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Retrieves the venue of the show.
     *
     * @return The venue.
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * Method to add a ticket to the show.
     *
     * @param ticket The ticket to be added.
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket " + ticket.getTicketId() + " added to the show " + showId);
    }

    /**
     * Method to remove a ticket from the show.
     *
     * @param ticket The ticket to be removed.
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        System.out.println("Ticket " + ticket.getTicketId() + " removed from show " + showId);
    }

    /**
     * Method to get the list of available tickets for the show.
     *
     * @return The list of available tickets.
     */
    public List<Ticket> getAvailableTickets() {
        List<Ticket> availableTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getStatus().equals("Available")) {
                availableTickets.add(ticket);
            }
        }
        return availableTickets;
    }

    /**
     * Method to add a seat to the show.
     * 
     * @param seat The seat to be added.
     */
    public void addSeat(Seat seat) {
        seats.add(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " added to show " + showId);
    }

    /**
     * Method to remove a seat from the show.
     * 
     * @param seat The seat to be removed.
     */
    public void removeSeat(Seat seat) {
        seats.remove(seat);
        System.out.println("Seat " + seat.getSeatNumber() + " removed from show " + showId);
    }

    /**
     * Retrieves the seats in the show.
     * 
     * @return An iterable of seats in the show.
     */
    public Iterable<Seat> getSeats() {
        return seats;
    }
}