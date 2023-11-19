package ticketbookingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    private final HashMap<String, Ticket> tickets;

    public TicketServiceImpl() {
        tickets = new HashMap<>();
    }

    @Override
    public void addTicket(Ticket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        return tickets.get(ticketId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets.values());
    }

    public void addGameTicket(GameTicket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
        System.out.println("Game ticket " + ticket.getTicketId() + " incorporated in the booking system.");
    }

    public void addShowTicket(ShowTicket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
        System.out.println("Show ticket " + ticket.getTicketId() + " incorporated in the booking system.");
    }

    public void addTrainTicket(TrainTicket ticket) {
        tickets.put(ticket.getTicketId(), ticket);
        System.out.println("Train ticket " + ticket.getTicketId() + " incorporated in the booking system.");
    }

    @Override
    public void addTicket(TrainTicket ticket) {
        addTrainTicket(ticket);
    }

    @Override
    public void addTicket(GameTicket ticket) {
        addGameTicket(ticket);
    }

    @Override
    public void addTicket(ShowTicket ticket) {
        addShowTicket(ticket);
    }
}