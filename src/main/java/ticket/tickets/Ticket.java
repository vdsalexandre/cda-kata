package ticket.tickets;

import java.util.Date;
import java.util.Objects;

public class Ticket {
    private final TicketId id;
    private final Price price;
    private final String label;
    private final String conditions;
    private final String description;
    private final boolean isDated;
    private final Date validityStartDate;
    private final Date validityEndDate;

    public Ticket(TicketId id, Price price, String label, String conditions, String description, boolean isDated, Date validityStartDate, Date validityEndDate) {
        this.id = id;
        this.price = price;
        this.label = label;
        this.conditions = conditions;
        this.description = description;
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

    public String getLabel() {
        return label;
    }

    public String getConditions() {
        return conditions;
    }

    public String getDescription() {
        return description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return isDated() == ticket.isDated() && Objects.equals(getId(), ticket.getId()) && Objects.equals(getPrice(), ticket.getPrice()) && Objects.equals(getLabel(), ticket.getLabel()) && Objects.equals(getConditions(), ticket.getConditions()) && Objects.equals(getDescription(), ticket.getDescription()) && Objects.equals(getValidityStartDate(), ticket.getValidityStartDate()) && Objects.equals(getValidityEndDate(), ticket.getValidityEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getLabel(), getConditions(), getDescription(), isDated(), getValidityStartDate(), getValidityEndDate());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", label='" + label + '\'' +
                ", conditions='" + conditions + '\'' +
                ", description='" + description + '\'' +
                ", isDated=" + isDated +
                ", validityStartDate=" + validityStartDate +
                ", validityEndDate=" + validityEndDate +
                '}';
    }
}
