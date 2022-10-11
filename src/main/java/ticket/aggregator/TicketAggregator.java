package ticket.aggregator;

import metadata.api.MetadataTicketRepository;
import metadata.tickets.TicketFromMetadata;
import ticket.tickets.Ticket;
import ticket.tickets.TicketId;
import ticketing.api.TicketingTicketRepository;
import ticketing.tickets.TicketFromTicketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TicketAggregator {

    private final MetadataTicketRepository metadataTicketRepository;
    private final TicketingTicketRepository ticketingTicketRepository;

    public TicketAggregator(MetadataTicketRepository metadataTicketRepository, TicketingTicketRepository ticketingTicketRepository) {
        this.metadataTicketRepository = metadataTicketRepository;
        this.ticketingTicketRepository = ticketingTicketRepository;
    }

    public List<Ticket> listTickets() {
        List<TicketFromMetadata> ticketsFromMetadata = metadataTicketRepository.listTickets();
        List<TicketFromTicketing> ticketsFromTicketing = ticketingTicketRepository.listTickets();

        ArrayList<Ticket> tickets = new ArrayList<>();

        for (TicketFromMetadata ticketFromMetadata : ticketsFromMetadata) {
            for (TicketFromTicketing ticketFromTicketing : ticketsFromTicketing) {
                if (ticketFromMetadata.getId().equals(ticketFromTicketing.getId())) {
                    tickets.add(aggregateTicket(ticketFromMetadata, ticketFromTicketing));
                }
            }
        }
        return tickets;
    }

    public Ticket getTicket(TicketId id) {
        Optional<TicketFromMetadata> ticketFromMetadata = metadataTicketRepository
                .listTickets()
                .stream()
                .filter((ticket -> ticket.getId().equals(id)))
                .findFirst();

        Optional<TicketFromTicketing> ticketFromTicketing = ticketingTicketRepository
                .listTickets()
                .stream()
                .filter((ticket -> ticket.getId().equals(id)))
                .findFirst();

        if (ticketFromMetadata.isPresent() && ticketFromTicketing.isPresent()) {
            return aggregateTicket(ticketFromMetadata.get(), ticketFromTicketing.get());
        }
        return null;
    }

    public List<Ticket> listDatedTickets() {
        Date currentDate = new Date(2022, 9, 11);

        return listTickets()
                .stream()
                .filter(ticket -> currentDate.after(ticket.getValidityStartDate()) && currentDate.before(ticket.getValidityEndDate()))
                .collect(Collectors.toList());
    }

    public List<Ticket> listUndatedTickets() {
        Date currentDate = new Date(2022, 9, 11);

        return listTickets()
                .stream()
                .filter(ticket -> currentDate.after(ticket.getValidityEndDate()))
                .collect(Collectors.toList());
    }

    public List<Ticket> listValidTickets(Date date) {
        return listTickets()
                .stream()
                .filter(ticket -> date.after(ticket.getValidityStartDate()) && date.before(ticket.getValidityEndDate()))
                .collect(Collectors.toList());
    }

    private Ticket aggregateTicket(TicketFromMetadata ticketFromMetadata, TicketFromTicketing ticketFromTicketing) {
        return new Ticket(
                ticketFromMetadata.getId(),
                ticketFromTicketing.getPrice(),
                ticketFromMetadata.getLabel(),
                ticketFromMetadata.getConditions(),
                ticketFromMetadata.getDescription(),
                ticketFromTicketing.isDated(),
                ticketFromTicketing.getValidityStartDate(),
                ticketFromTicketing.getValidityEndDate()
        );
    }
}
