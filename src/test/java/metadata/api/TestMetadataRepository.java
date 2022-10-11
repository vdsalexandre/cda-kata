package metadata.api;

import metadata.tickets.TicketFromMetadata;
import ticket.tickets.TicketId;

import java.util.ArrayList;
import java.util.List;

public class TestMetadataRepository implements MetadataTicketRepository {

    @Override
    public List<TicketFromMetadata> listTickets() {
        List<TicketFromMetadata> ticketList = new ArrayList<>();
        ticketList.add(getTicketGaulois());
        ticketList.add(getTicketFute());
        ticketList.add(getTicketLiberte());
        return ticketList;
    }

    @Override
    public TicketFromMetadata getTicket(TicketId id) {
        List<TicketFromMetadata> ticketList = listTickets();
        for(TicketFromMetadata ticket: ticketList) {
            if (ticket.getId().equals(id)) return ticket;
        }
        return null;
    }

    public TicketFromMetadata getTicketGaulois() {
        TicketId id = new TicketId("GAULOIS");
        String label = "Le billet gaulois";
        String conditions = "Choisir une date";
        String description = "ce billet permet de venir au Parc à une date donnée";
        return new TicketFromMetadata(id, label, conditions, description);
    }

    public TicketFromMetadata getTicketFute() {
        TicketId id = new TicketId("FUTE");
        String label = "Le billet futé";
        String conditions = "Valable toute l'année sauf noël et halloween";
        String description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, sous conditions";
        return new TicketFromMetadata(id, label, conditions, description);
    }

    public TicketFromMetadata getTicketLiberte() {
        TicketId id = new TicketId("LIBERTE");
        String label = "Le billet liberté";
        String conditions = "Valable toute l'année même noël et halloween";
        String description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, même les jours de fête";
        return new TicketFromMetadata(id, label, conditions, description);
    }
}
