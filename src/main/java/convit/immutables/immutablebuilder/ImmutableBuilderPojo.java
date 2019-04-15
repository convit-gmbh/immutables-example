package convit.immutables.immutablebuilder;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@JsonDeserialize(builder = ImmutableBuilderPojoBuilder.class)
class ImmutableBuilderPojo {

    private final int xInMs;
    private final ImmutableList<String> names;
    private final UserData userData;

    ImmutableBuilderPojo(int xInMs, ImmutableList<String> names, UserData userData) {
        this.xInMs = xInMs;
        this.names = names;
        this.userData = userData;
    }

    public int getxInMs() {
        return xInMs;
    }

    public ImmutableList<String> getNames() {
        return names;
    }

    public UserData getUserData() {
        return userData;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        ImmutableBuilderPojo that = (ImmutableBuilderPojo) o;
        return xInMs == that.xInMs &&
            Objects.equals(names, that.names) &&
            Objects.equals(userData, that.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xInMs, names, userData);
    }
}
