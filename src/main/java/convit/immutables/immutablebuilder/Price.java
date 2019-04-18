package convit.immutables.immutablebuilder;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Price {

    private final double amount;
    private final String currency;

    @JsonCreator
    public Price(@JsonProperty("amount") double amount, @JsonProperty("currency") String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Price price = (Price) o;
        return Double.compare(price.amount, amount) == 0 &&
            Objects.equals(currency, price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
