package ticketbookingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the booking system.
 * Authors: Sophie and Edward
 */
public class BookingSystem {
    
    // TicketService instance for managing tickets
    private final TicketService ticketService;
    
    // Lists for storing trains, games, shows, and their respective tickets
    private final List<Train> trains;
    private final List<Game> games;
    private final List<Show> shows;
    private final List<TrainTicket> trainTickets;
    private final List<GameTicket> gameTickets;
    private final List<ShowTicket> showTickets;

    /**
     * Constructor for the BookingSystem class.
     * Initializes the TicketService and the lists.
     */
    public BookingSystem() {
        ticketService = new TicketServiceImpl();
        trains = new ArrayList<>();
        games = new ArrayList<>();
        shows = new ArrayList<>();
        trainTickets = new ArrayList<>();
        gameTickets = new ArrayList<>();
        showTickets = new ArrayList<>();
        
        // Initialize trains, games, and shows with seats
        initializeTrains();
        initializeGames();
        initializeShows();
    }

    /**
     * Method to initialize trains with seats.
     */
    private void initializeTrains() {
        for (int i = 1; i <= 10; i++) {
            Train train = new Train("Train" + i, "Train Name " + i, new Venue("Venue" + i), 100.0);
            for (int j = 1; j <= 100; j++) {
                Seat seat = new Seat(Integer.toString(j));
                train.addSeat(seat);
            }
            trains.add(train);
        }
    }

    /**
     * Method to initialize games with seats.
     */
    private void initializeGames() {
        for (int i = 1; i <= 10; i++) {
            Game game = new Game("Game" + i, "Game Name " + i, new Venue("Venue" + i), 100.0);
            for (int j = 1; j <= 100; j++) {
                Seat seat = new Seat(Integer.toString(j));
                game.addSeat(seat);
            }
            games.add(game);
        }
    }

    /**
     * Method to initialize shows with seats.
     */
    private void initializeShows() {
        for (int i = 1; i <= 10; i++) {
            Show show = new Show("Show" + i, new Event("Event" + i), new Venue("Venue" + i), 100.0);
            for (int j = 1; j <= 100; j++) {
                Seat seat = new Seat(Integer.toString(j));
                show.addSeat(seat);
            }
            shows.add(show);
        }
    }

    /**
     * Method to add a train to the booking system.
     * 
     * @param train The train to be added.
     */
    public void addTrain(Train train) {
        trains.add(train);
        System.out.println("Train " + train.getTrainId() + " incorporated to the booking system.");
    }

    /**
     * Method to add a game to the booking system.
     * 
     * @param game The game to be added.
     */
    public void addGame(Game game) {
        games.add(game);
        System.out.println("Game " + game.getGameId() + " incorporated to the booking system.");
    }

    /**
     * Method to add a show to the booking system.
     * 
     * @param show The show to be added.
     */
    public void addShow(Show show) {
        shows.add(show);
        System.out.println("Display " + show.getShowId() + " incorporated to the booking system.");
    }

    /**
     * Method to add a train ticket to the booking system.
     * 
     * @param ticket The train ticket to be added.
     */
    public void addTrainTicket(TrainTicket ticket) {
        trainTickets.add(ticket);
        ticketService.addTicket(ticket); // Use TicketService to manage tickets
        System.out.println("Train ticket " + ticket.getTicketId() + " incorporated to the booking system.");
    }

    /**
     * Method to add a game ticket to the booking system.
     * 
     * @param ticket The game ticket to be added.
     */
    public void addGameTicket(GameTicket ticket) {
        gameTickets.add(ticket);
        ticketService.addTicket(ticket); // Use TicketService to manage tickets
        System.out.println("Game ticket " + ticket.getTicketId() + " incorporated in the booking system.");
    }

    /**
     * Method to add a show ticket to the booking system.
     * 
     * @param ticket The show ticket to be added.
     */
    public void addShowTicket(ShowTicket ticket) {
        showTickets.add(ticket);
        ticketService.addTicket(ticket); // Use TicketService to manage tickets
        System.out.println("Show ticket " + ticket.getTicketId() + " incorporated in the booking system.");
    }

    /**
     * Method to get a seat by its number.
     * It checks the seats in the Train, Game, and Show objects.
     * 
     * @param seatNumber The number of the seat.
     * @return The Seat object if found, null otherwise.
     */
    public Seat getSeatByNumber(int seatNumber) {
        // Check the seats in the Train objects
        for (Train train : trains) {
            for (Seat seat : train.getSeats()) {
                if (Integer.parseInt(seat.getSeatNumber()) == seatNumber) {
                    return seat;
                }
            }
        }

        // Check the seats in the Game objects
        for (Game game : games) {
            for (Seat seat : game.getSeats()) {
                if (Integer.parseInt(seat.getSeatNumber()) == seatNumber) {
                    return seat;
                }
            }
        }

        // Check the seats in the Show objects
        for (Show show : shows) {
            for (Seat seat : show.getSeats()) {
                if (Integer.parseInt(seat.getSeatNumber()) == seatNumber) {
                    return seat;
                }
            }
        }

        return null; // Return null if seat with given number is not found
    }

    public Train getTrainById(String id) {
        for (Train train : trains) {
            if (train.getTrainId().equals(id)) {
                return train;
            }
        }
        return null; // Return null if train with given ID is not found
    }

    public Game getGameById(String id) {
        for (Game game : games) {
            if (game.getGameId().equals(id)) {
                return game;
            }
        }
        return null; // Return null if game with given ID is not found
    }

    public Show getShowById(String id) {
        for (var show : shows) {
            if (show.getShowId().equals(id)) {
                return show;
            }
        }
        return null; // Return null if show with given ID is not found
    }
    
    /**
     * Method to get all train tickets in the booking system.
     * 
     * @return A list of all train tickets.
     */
    public List<TrainTicket> getAllTickets() {
        return trainTickets;
    }
}