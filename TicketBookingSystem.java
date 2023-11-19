package ticketbookingsystem;

import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

/**
 * This class represents the main Ticket Booking System application.
 * Authors: Sophie and Edward
 */
public class TicketBookingSystem {

    // Create an instance of the BookingSystem class
    static BookingSystem bookingSystem = new BookingSystem();
    // Create a Scanner object for taking user input
    Scanner scanner = new Scanner(System.in);

        /**
     * The bookTicket method handles the ticket booking process.
     * It prompts the user for their name and the details of the ticket they want to book.
     * It then creates a Ticket object and adds it to the BookingSystem.
     * 
     * @param type The type of the ticket (Train, Game, or Show)
     */
    public void bookTicket(String type) {
        // Prompt the user for the ID of the Train, Game, or Show
        System.out.println("Enter " + type + " ID: ");
        String id = scanner.nextLine();
        // Prompt the user for the seat number
        System.out.println("Enter Seat Number: ");
        int seatNumber;
        try {
            seatNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid seat number. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            return;
        }
        scanner.nextLine(); // Consume newline left-over
        // Prompt the user for their name
        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();

        // Assuming you have a method to get a Seat by seatNumber
        Seat seat = bookingSystem.getSeatByNumber(seatNumber);
        if (seat == null) {
            System.out.println("Invalid seat number.");
            return;
        }

        // Assuming you have a method to get a Train, Game, or Show by id
        switch (type) {
            case "Train":
                Train train = bookingSystem.getTrainById(id);
                if (train == null) {
                    System.out.println("Invalid train ID.");
                    return;
                }
                TrainTicket trainTicket = new TrainTicket(id, train, seat, customerName, "berthType");
                bookingSystem.addTrainTicket(trainTicket);
                break;
            case "Game":
                Game game = bookingSystem.getGameById(id);
                if (game == null) {
                    System.out.println("Invalid game ID.");
                    return;
                }
                GameTicket gameTicket = new GameTicket(id, game, seat, customerName);
                bookingSystem.addGameTicket(gameTicket);
                break;
            case "Show":
                Show show = bookingSystem.getShowById(id);
                if (show == null) {
                    System.out.println("Invalid show ID.");
                    return;
                }
                ShowTicket showTicket = new ShowTicket(id, show, seat, customerName);
                bookingSystem.addShowTicket(showTicket);
                break;
        }

        // Save tickets to file after booking
        saveTickets();
    }

    /**
     * The saveTickets method saves all the tickets to the tickets.txt file.
     */
    public static void saveTickets() {
        try {
            FileWriter writer = new FileWriter("tickets.txt");
            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                for (TrainTicket ticket : bookingSystem.getAllTickets()) {
                    bufferedWriter.write(ticket.getTicketId() + "," + ticket.getTrain().getTrainId() + "," + ticket.getSeat().getSeatNumber() + "," + ticket.getCustomerName() + "," + ticket.getBerthType());
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving tickets: " + e.getMessage());
        }
    }

    /**
     * The loadTickets method loads all the tickets from the tickets.txt file.
     */
    public static void loadTickets() {
        try {
            FileReader reader = new FileReader("tickets.txt");
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] properties = line.split(",");
                    Train train = bookingSystem.getTrainById(properties[1]);
                    Seat seat = bookingSystem.getSeatByNumber(Integer.parseInt(properties[2]));
                    TrainTicket ticket = new TrainTicket(properties[0], train, seat, properties[3], properties[4]);
                    bookingSystem.addTrainTicket(ticket);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No saved tickets found.");
        } catch (IOException e) {
            System.out.println("Error loading tickets: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create an instance of the TicketBookingSystem class
        TicketBookingSystem ticketBookingSystem = new TicketBookingSystem();

        // Load tickets from file at the start of the program
        TicketBookingSystem.loadTickets();

        // Main loop
        while (true) {
            // Display the main menu
            System.out.println("Welcome to the Ticket Booking System!");
            System.out.println("1. Book a Train Ticket");
            System.out.println("2. Book a Game Ticket");
            System.out.println("3. Book a Show Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice of ticket based on number: ");

            // Get the user's choice
            int choice = ticketBookingSystem.scanner.nextInt();
            ticketBookingSystem.scanner.nextLine(); // Consume newline left-over

            // Process the user's choice
            switch (choice) {
                case 1:
                    ticketBookingSystem.bookTicket("Train");
                    break;
                case 2:
                    ticketBookingSystem.bookTicket("Game");
                    break;
                case 3:
                    ticketBookingSystem.bookTicket("Show");
                    break;
                case 4:
                    System.out.println("Thank you for using the Ticket Booking System!");
                    ticketBookingSystem.scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }
}