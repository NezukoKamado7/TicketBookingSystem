package ticketbookingsystem;

/**
 * This class represents a venue in the ticket booking system.
 * Authors: Sophie and Edward
 */
public class Venue {
    private final String venueId; // The ID of the venue
    private final String name; // The name of the venue
    private final String address; // The address of the venue

    /**
     * Constructor for the Venue class.
     * @param venueId The ID of the venue.
     * @param name The name of the venue.
     * @param address The address of the venue.
     */
    public Venue(String venueId, String name, String address) {
        this.venueId = venueId;
        this.name = name;
        this.address = address;
    }

    /**
     * Constructor for the Venue class that only takes a name.
     * The venueId and address fields are initialized with default values.
     * @param name The name of the venue.
     */
    public Venue(String name) {
        this.venueId = "Default ID";
        this.name = name;
        this.address = "Default Address";
    }

    /**
     * Getter method for the venue ID.
     * @return The venue ID.
     */
    public String getVenueId() {
        return venueId;
    }

    /**
     * Getter method for the venue name.
     * @return The venue name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the venue address.
     * @return The venue address.
     */
    public String getAddress() {
        return address;
    }
}