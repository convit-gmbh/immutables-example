package convit.immutables.immutablebuilder;

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
        ImmutableBuilderPojo immutableBuilderPojo = new ImmutableBuilderPojoBuilder()
            .xInMs(123)
            .userData(new UserData("data"))
            .names(newArrayList("Fred", "Rolf", "Wagner"))
            .build();

        String json = mapper.writeValueAsString(immutableBuilderPojo);

        assertThat(json).isEqualTo(expectedJson);
    }

    @Test
    void deserialize_from_json() throws IOException {
        ImmutableBuilderPojo immutableBuilderPojo = mapper.readValue(expectedJson, ImmutableBuilderPojo.class);

        assertThat(immutableBuilderPojo).isEqualTo(new ImmutableBuilderPojoBuilder()
            .xInMs(123)
            .userData(new UserData("data"))
            .names(newArrayList("Fred", "Rolf", "Wagner"))
            .build());
    }

}