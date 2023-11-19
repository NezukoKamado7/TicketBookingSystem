package ticketbookingsystem;

/**
 * The Seat class represents a seat in a booking system.
 * Authors: Sophie and Edward
 */
public class Seat {

    private final String id;              // The ID of the seat
    private boolean isBooked;       // The booking status of the seat
    private final SeatType type;          // The type of the seat

    /**
     * Constructor for the Seat class that only takes an ID.
     * The type field is initialized with a default value.
     * @param id The ID of the seat.
     */
    public Seat(String id) {
        this.id = id;
        this.type = SeatType.ECONOMY;
        this.isBooked = false;
    }

    /**
     * The SeatType enumeration represents the type of the seat.
     */
    public enum SeatType {
        FIRSTCLASS,
        ECONOMY
    }

    /**
     * Constructor initializes a new Seat instance.
     *
     * @param id   The ID of the seat.
     * @param type The type of the seat.
     */
    public Seat(String id, SeatType type) {
        this.id = id;
        this.type = type;
        this.isBooked = false;
    }

    /**
     * Retrieves the ID of the seat.
     *
     * @return The ID of the seat.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the type of the seat.
     *
     * @return The type of the seat.
     */
    public SeatType getType() {
        return type;
    }

    /**
     * Checks if the seat is booked.
     *
     * @return true if the seat is booked, false otherwise.
     */
    public boolean isBooked() {
        return isBooked;
    }

    /**
     * Books the seat.
     *
     * If the seat is not booked, it changes the status to booked and prints a success message.
     * If the seat is already booked, it prints a failure message.
     */
    public void book() {
        if (!isBooked) {
            System.out.println("Seat " + id + " is now booked.");
            this.isBooked = true;
        } else {
            System.out.println("Seat " + id + " is already booked.");
        }
    }

    /**
     * Cancels the booking of the seat.
     *
     * If the seat is booked, it changes the status to available and prints a success message.
     * If the seat is already available, it prints a failure message.
     */
    public void cancel() {
        if (isBooked) {
            System.out.println("Seat " + id + " is now available.");
            this.isBooked = false;
        } else {
            System.out.println("Seat " + id + " is already available.");
        }
    }

    /**
     * Retrieves the seat number.
     *
     * @return The seat number.
     */
    public String getSeatNumber() {
        return id;
    }

    /**
     * Checks if the seat is available.
     *
     * @return true if the seat is available, false otherwise.
     */
    public boolean isAvailable() {
        return !isBooked;
    }
}