package convit.immutables.immutables;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ImmutablePojoTest {

    private String expectedJson = "{\"xInMs\":123,\"names\":[\"Fred\",\"Rolf\",\"Wagner\"],\"userData\":{\"data\":\"data\"}}";

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void serialize_to_json() throws JsonProcessingException {
        ImmutablesImmutableObject immutablesImmutableObject = ImmutableImmutablesImmutableObject.builder()
            .xInMs(123)
            .userData(ImmutableUserData.builder().data("data").build())
            .names(newArrayList("Fred", "Rolf", "Wagner"))
            .build();

        String json = mapper.writeValueAsString(immutablesImmutableObject);

        assertThat(json).isEqualTo(expectedJson);
    }

    @Test
    void deserialize_from_json() throws IOException {
        ImmutablesImmutableObject immutablesImmutableObject = mapper.readValue(expectedJson, ImmutablesImmutableObject.class);

        assertThat(immutablesImmutableObject).isEqualTo(ImmutableImmutablesImmutableObject.builder()
            .xInMs(123)
            .userData(ImmutableUserData.builder().data("data").build())
            .names(newArrayList("Fred", "Rolf", "Wagner"))
            .build());
    }

}