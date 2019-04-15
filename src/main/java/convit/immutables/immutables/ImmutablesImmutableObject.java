package convit.immutables.immutables;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@Value.Immutable
@JsonDeserialize(builder = ImmutableImmutablesImmutableObject.Builder.class)
interface ImmutablesImmutableObject {

    int xInMs();

    ImmutableList<String> names();

    UserData userData();

}
