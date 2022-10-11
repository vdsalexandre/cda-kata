package ticketing.api;

import ticket.tickets.TicketId;
import ticketing.tickets.TicketFromTicketing;

import java.util.List;

public interface TicketingTicketRepository {
    public List<TicketFromTicketing> listTickets();
    public TicketFromTicketing getTicket(TicketId id);
}
