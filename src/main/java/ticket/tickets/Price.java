package ticket.tickets;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price {
    private final BigDecimal value;
    private final Currency currency;
    private final BigDecimal taxValue;

    public Price(BigDecimal value, Currency currency, BigDecimal taxValue) {
        this.value = value;
        this.currency = currency;
        this.taxValue = taxValue;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value) && Objects.equals(currency, price.currency) && Objects.equals(taxValue, price.taxValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency, taxValue);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                ", taxValue=" + taxValue +
                '}';
    }
}
