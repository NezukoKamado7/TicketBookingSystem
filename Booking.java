package ticketbookingsystem;

import java.util.List;

/**
 * This class represents a booking in the ticket booking system.
 * Author: Sophie and Edward
 */
public class Booking {
    
    private final String bookingId;       // Unique identifier for the booking
    private final Customer customer;      // The customer who made the booking
    private final Event event;            // The event for which the booking is made
    private final List<Ticket> tickets;   // List of tickets that are booked
    
    /**
     * Constructor for the Booking class.
     * 
     * @param bookingId The ID of the booking.
     * @param customer The customer who made the booking.
     * @param event The event for which the booking is made.
     * @param tickets The tickets that are booked.
     */
    public Booking(String bookingId, Customer customer, Event event, List<Ticket> tickets) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.event = event;
        this.tickets = tickets;
    }
    
    /**
     * Retrieves the booking ID.
     * 
     * @return The booking ID.
     */
    public String getBookingId() {
        return bookingId;
    }
    
    /**
     * Retrieves the customer who made the booking.
     * 
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Retrieves the event for which the booking is made.
     * 
     * @return The event.
     */
    public Event getEvent() {
        return event;
    }
    
    /**
     * Retrieves the list of tickets that are booked.
     * 
     * @return The list of tickets.
     */
    public List<Ticket> getTickets() {
        return tickets;
    }
    
    /**
     * Cancels the booking. It cancels all the tickets in the booking,
     * removes them from the customer's list of tickets, and the event's list of tickets.
     */
    public void cancel() {
        for(Ticket ticket : tickets) {
            ticket.cancel();
            customer.cancelTicket(event, ticket);
            event.removeTicket(ticket);
        }
        System.out.println("You have cancelled the booking for the ticket " + bookingId);
    }
}