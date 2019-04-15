package convit.immutables.pojo;

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
        ImmutablePojo immutableObject = new ImmutablePojoBuilder()
            .xInMs(123)
            .userData(new UserData("data"))
            .names(newArrayList("Fred", "Rolf", "Wagner"))
            .build();

        String json = mapper.writeValueAsString(immutableObject);

        assertThat(json).isEqualTo(expectedJson);
    }

    @Test
    void deserialize_from_json() throws IOException {
        ImmutablePojo immutableObject = mapper.readValue(expectedJson, ImmutablePojo.class);

        assertThat(immutableObject).isEqualTo(new ImmutablePojoBuilder()
            .xInMs(123)
            .userData(new UserData("data"))
            .names(newArrayList("Fred", "Rolf", "Wagner"))
            .build());
    }

}