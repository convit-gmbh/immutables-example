package convit.immutables.immutablebuilder;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;

@JsonPOJOBuilder(withPrefix = "")
class ImmutableBuilderPojoBuilder {

    private final int xInMs;
    private final ImmutableList<String> names;
    private final UserData userData;

    ImmutableBuilderPojoBuilder() {
        this(0, ImmutableList.of(), null);
    }

    ImmutableBuilderPojoBuilder(int xInMs, ImmutableList<String> names, UserData userData) {
        this.xInMs = xInMs;
        this.names = names;
        this.userData = userData;
    }

    public ImmutableBuilderPojoBuilder xInMs(int xInMs) {
        return new ImmutableBuilderPojoBuilder(xInMs, names, userData);
    }

    public ImmutableBuilderPojoBuilder names(List<String> names) {
        return new ImmutableBuilderPojoBuilder(xInMs, ImmutableList.copyOf(names), userData);
    }

    public ImmutableBuilderPojoBuilder userData(UserData userData) {
        return new ImmutableBuilderPojoBuilder(xInMs, names, userData);
    }

    public ImmutableBuilderPojo build() {
        return new ImmutableBuilderPojo(xInMs, names, userData);
    }

}
