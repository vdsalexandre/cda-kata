package ticket.aggregator;

import metadata.api.MetadataTicketRepository;
import metadata.api.TestMetadataRepository;
import org.junit.jupiter.api.Test;
import ticket.tickets.Price;
import ticket.tickets.Ticket;
import ticket.tickets.TicketId;
import ticketing.api.TestTicketingRepository;
import ticketing.api.TicketingTicketRepository;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatIterable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TicketAggregatorTest {

    private MetadataTicketRepository metadataTicketRepository = new TestMetadataRepository();
    private TicketingTicketRepository ticketingTicketRepository = new TestTicketingRepository();
    private TicketAggregator ticketAggregator = new TicketAggregator(metadataTicketRepository, ticketingTicketRepository);

    @Test
    void listTickets() {
        // GIVEN
        List<Ticket> expected = getTicketList();
        // WHEN
        List<Ticket> tickets = ticketAggregator.listTickets();
        // THEN
        assertThatIterable(tickets).isEqualTo(expected);
    }

    @Test
    void getTicket() {
        // GIVEN
        Ticket expected = getTicketGaulois();
        //WHEN
        Ticket ticket = ticketAggregator.getTicket(expected.getId());
        //THEN
        assertThat(ticket).isEqualTo(expected);
    }

    @Test
    void listDatedTickets() {
        List<Ticket> expected = List.of(getTicketGaulois(), getTicketLiberte());

        List<Ticket> result = ticketAggregator.listDatedTickets();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void listUndatedTickets() {
        List<Ticket> expected = List.of(getTicketFute());

        List<Ticket> result = ticketAggregator.listUndatedTickets();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void listValidTickets() {
        List<Ticket> expected = List.of(getTicketGaulois(), getTicketLiberte());
        Date expectedDate = new Date(2022, 0, 2);

        List<Ticket> result = ticketAggregator.listValidTickets(expectedDate);

        assertThat(result).isEqualTo(expected);
    }

    private List<Ticket> getTicketList() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(getTicketGaulois());
        ticketList.add(getTicketFute());
        ticketList.add(getTicketLiberte());
        return ticketList;
    }

    private Ticket getTicketGaulois() {
        TicketId id = new TicketId("GAULOIS");
        String label = "Le billet gaulois";
        String conditions = "Choisir une date";
        String description = "ce billet permet de venir au Parc à une date donnée";
        BigDecimal priceValue = new BigDecimal(40);
        BigDecimal taxValue = new BigDecimal(4);
        Price price = new Price(priceValue, Currency.getInstance("EUR"), taxValue);
        Date startDate = new Date(2022, 0, 1);
        Date endDate = new Date(2022, 11, 31);
        return new Ticket(id, price, label, conditions, description, true, startDate, endDate);
    }

    private Ticket getTicketFute() {
        TicketId id = new TicketId("FUTE");
        String label = "Le billet futé";
        String conditions = "Valable toute l'année sauf noël et halloween";
        String description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, sous conditions";
        BigDecimal priceValue = new BigDecimal(50);
        BigDecimal taxValue = new BigDecimal(5);
        Price price = new Price(priceValue, Currency.getInstance("EUR"), taxValue);
        Date startDate = new Date(2021, 0, 1);
        Date endDate = new Date(2021, 11, 31);
        return new Ticket(id, price, label, conditions, description, false, startDate, endDate);
    }

    private Ticket getTicketLiberte() {
        TicketId id = new TicketId("LIBERTE");
        BigDecimal priceValue = new BigDecimal(60);
        BigDecimal taxValue = new BigDecimal(6);
        String label = "Le billet liberté";
        String conditions = "Valable toute l'année même noël et halloween";
        String description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, même les jours de fête";
        Price price = new Price(priceValue, Currency.getInstance("EUR"), taxValue);
        Date startDate = new Date(2022, 0, 1);
        Date endDate = new Date(2022, 11, 31);
        return new Ticket(id, price, label, conditions, description, false, startDate, endDate);
    }

}