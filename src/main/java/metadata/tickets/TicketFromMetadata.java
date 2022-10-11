package metadata.tickets;

import ticket.tickets.TicketId;

public class TicketFromMetadata {
    private final TicketId id;
    private final String label;
    private final String conditions;
    private final String description;

    public TicketFromMetadata(TicketId id, String label, String conditions, String description) {
        this.id = id;
        this.label = label;
        this.conditions = conditions;
        this.description = description;
    }

    public TicketId getId() {
        return id;
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
}
