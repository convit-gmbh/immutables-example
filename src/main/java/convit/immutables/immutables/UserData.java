package convit.immutables.immutables;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(builder = ImmutableUserData.Builder.class)
interface UserData {

    String data();

}
