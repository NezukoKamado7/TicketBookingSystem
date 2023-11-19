package ticketbookingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents an event in the ticket booking system.
 * Authors: Sophie and Edward
 */
public class Event {
    
    private final String eventId;             // Unique identifier for the event
    private final String name;                // Name of the event
    private final Date date;                  // Date of the event
    private final String venue;               // Venue of the event
    private final List<Ticket> tickets;       // List of tickets associated with the event
    
    /**
     * Constructor for the Event class.
     * 
     * @param eventId The ID of the event.
     * @param name The name of the event.
     * @param date The date of the event.
     * @param venue The venue of the event.
     */
    public Event(String eventId, String name, Date date, String venue) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.tickets = new ArrayList<>();
    }

    /**
     * Constructor for the Event class that only takes a name.
     * The eventId, date, and venue fields are initialized with default values.
     * 
     * @param name The name of the event.
     */
    public Event(String name) {
        this.eventId = "Default ID";
        this.name = name;
        this.date = new Date();
        this.venue = "Default Venue";
        this.tickets = new ArrayList<>();
    }

    /**
     * Retrieves the event ID.
     * 
     * @return The event ID.
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Retrieves the event name.
     * 
     * @return The event name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the event date.
     * 
     * @return The event date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the event venue.
     * 
     * @return The event venue.
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Adds a ticket to the event.
     * 
     * @param ticket The ticket to be added.
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("Ticket " + ticket.getTicketId() + " incorporated to the event " + name);
    }

    /**
     * Removes a ticket from the event.
     * 
     * @param ticket The ticket to be removed.
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        System.out.println("Ticket " + ticket.getTicketId() + " removed from the event " + name);
    }

    /**
     * Retrieves a list of available tickets for the event.
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
}