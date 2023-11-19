package ticketbookingsystem;

/**
 * This class represents a payment in the ticket booking system.
 * Author: Sophie and Edward
 */
public class Payment {
    
    private final String paymentId;           // Unique identifier for the payment
    private final Customer customer;          // Customer who made the payment
    private final Booking booking;            // Booking for which the payment is made
    private final double amount;              // Total amount of the payment
    
    /**
     * Constructor for the Payment class.
     * 
     * @param paymentId The ID of the payment.
     * @param customer The customer who made the payment.
     * @param booking The booking for which the payment is made.
     * @param amount The total amount of the payment.
     */
    public Payment(String paymentId, Customer customer, Booking booking, double amount) {
        this.paymentId = paymentId;
        this.customer = customer;
        this.booking = booking;
        this.amount = amount;
    }

    /**
     * Retrieves the payment ID.
     * 
     * @return The payment ID.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Retrieves the customer who made the payment.
     * 
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Retrieves the booking for which the payment is made.
     * 
     * @return The booking.
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * Retrieves the total amount of the payment.
     * 
     * @return The total amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Processes the payment.
     * 
     * This method would typically communicate with a payment gateway to process the payment.
     * Since this is a simple example, we'll just print a message indicating that the payment was processed successfully.
     */
    public void process() {
        System.out.println("Processed payment " + paymentId + " of the dollar amount " + amount + " for booking " + booking.getBookingId());
    }
}