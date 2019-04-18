package convit.immutables.immutables;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(builder = ImmutableProduct.Builder.class)
interface Product {

    String name();

    Price price();

    List<String> images();

    static ImmutableProduct.Builder builder() {
        return ImmutableProduct.builder();
    }

}
