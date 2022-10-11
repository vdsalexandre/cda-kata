package ticket.tickets;

import java.util.Objects;

public class TicketId {
    private final String value;

    public TicketId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketId ticketId = (TicketId) o;
        return Objects.equals(getValue(), ticketId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "TicketId{" +
                "value='" + value + '\'' +
                '}';
    }
}
