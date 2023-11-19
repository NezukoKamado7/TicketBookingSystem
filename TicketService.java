package ticketbookingsystem;

import java.util.List;

public interface TicketService {
    void addTicket(Ticket ticket);
    Ticket getTicketById(String ticketId);
    List<Ticket> getAllTickets();

    public void addTicket(TrainTicket ticket);

    public void addTicket(GameTicket ticket);

    public void addTicket(ShowTicket ticket);
}
