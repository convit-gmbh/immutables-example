package convit.immutables.immutablebuilder;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

class ProductTest {

    private String expectedJson = "{\"name\":\"Android Phone 1\",\"price\":{\"amount\":600.0,\"currency\":\"USD\"},\"images\":[\"http://example.com/android1_image1.jpeg\",\"http://example.com/android1_image2.jpeg\",\"http://example.com/android1_image3.jpeg\"]}";

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void serialize_to_json() throws JsonProcessingException {
        Product product = Product.builder()
            .name("Android Phone 1")
            .price(new Price(600.0, "USD"))
            .images(newArrayList(
                "http://example.com/android1_image1.jpeg",
                "http://example.com/android1_image2.jpeg",
                "http://example.com/android1_image3.jpeg"
                )
            )
            .build();

        String json = mapper.writeValueAsString(product);

        assertThat(json).isEqualTo(expectedJson);
    }

    @Test
    void deserialize_from_json() throws IOException {
        Product product = mapper.readValue(expectedJson, Product.class);

        assertThat(product).isEqualTo(Product.builder()
            .name("Android Phone 1")
            .price(new Price(600.0, "USD"))
            .images(newArrayList(
                "http://example.com/android1_image1.jpeg",
                "http://example.com/android1_image2.jpeg",
                "http://example.com/android1_image3.jpeg"
                )
            )
            .build());
    }

    @Test
    void ensure_copy_copies_all_fields_to_new_builder() {
        Product product = new Product("Android Phone 1", new Price(600.0, "USD"), ImmutableList.of(
            "http://example.com/android1_image1.jpeg",
            "http://example.com/android1_image2.jpeg",
            "http://example.com/android1_image3.jpeg")
        );

        assertThat(Product.copy(product).build()).isEqualTo(product);
    }

}