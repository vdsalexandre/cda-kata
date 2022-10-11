package metadata.api;

import metadata.tickets.TicketFromMetadata;
import ticket.tickets.TicketId;

import java.util.List;

public interface MetadataTicketRepository {

    public List<TicketFromMetadata> listTickets();

    public TicketFromMetadata getTicket(TicketId id);
}
