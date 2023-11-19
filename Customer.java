package ticketbookingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a customer in the ticket booking system.
 * Author: Sophie and Edward
 */
public class Customer {
    
    private final String customerId;          // Unique identifier for the customer
    private final String name;                // Name of the customer
    private final String contactNumber;       // Contact number of the customer
    private final List<Ticket> tickets;       // List of tickets booked by the customer
    
    /**
     * Constructor for the Customer class.
     * 
     * @param customerId The ID of the customer.
     * @param name The name of the customer.
     * @param contactNumber The contact number of the customer.
     */
    public Customer(String customerId, String name, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.tickets = new ArrayList<>();
    }

    /**
     * Retrieves the customer ID.
     * 
     * @return The customer ID.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Retrieves the customer name.
     * 
     * @return The customer name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the customer contact number.
     * 
     * @return The customer contact number.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Books a ticket for a customer.
     * 
     * @param event The event for which the ticket is to be booked.
     * @param ticket The ticket to be booked.
     */
    public void bookTicket(Event event, Ticket ticket) {
        if(ticket.getStatus().equals("Available")) {
            ticket.book();
            tickets.add(ticket);
            event.addTicket(ticket);
            System.out.println("Customer " + name + " booked ticket " + ticket.getTicketId() + " for event " + event.getName());
        } else {
            System.out.println("Ticket " + ticket.getTicketId() + " for event " + event.getName() + " has already been booked.");
        }
    }

    /**
     * Cancels a ticket for a customer.
     * 
     * @param event The event for which the ticket is to be cancelled.
     * @param ticket The ticket to be cancelled.
     */
    public void cancelTicket(Event event, Ticket ticket) {
        if(ticket.getStatus().equals("Booked")) {
            ticket.cancel();
            tickets.remove(ticket);
            event.removeTicket(ticket);
            System.out.println("Customer " + name + " cancelled ticket " + ticket.getTicketId() + " for event " + event.getName());
        } else {
            System.out.println("Ticket " + ticket.getTicketId() + " for event " + event.getName() + " not currently booked.");
        }
    }
}