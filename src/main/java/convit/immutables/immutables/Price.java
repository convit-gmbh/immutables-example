package convit.immutables.immutables;

import java.util.Currency;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(builder = ImmutablePrice.Builder.class)
interface Price {

    double amount();

    String currency();

}
