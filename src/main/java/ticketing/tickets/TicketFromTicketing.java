package ticketing.tickets;

import ticket.tickets.Price;
import ticket.tickets.TicketId;

import java.util.Date;

public class TicketFromTicketing {
    private final TicketId id;
    private final Price price;
    private final boolean isDated;
    private final Date validityStartDate;
    private final Date validityEndDate;

    public TicketFromTicketing(TicketId id, Price price, boolean isDated, Date validityStartDate, Date validityEndDate) {
        this.id = id;
        this.price = price;
        this.isDated = isDated;
        this.validityStartDate = validityStartDate;
        this.validityEndDate = validityEndDate;
    }

    public TicketId getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public boolean isDated() {
        return isDated;
    }

    public Date getValidityStartDate() {
        return validityStartDate;
    }

    public Date getValidityEndDate() {
        return validityEndDate;
    }
}
