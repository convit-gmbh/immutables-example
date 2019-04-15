package convit.immutables.pojo;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@JsonDeserialize(builder = ImmutablePojoBuilder.class)
class ImmutablePojo {

    private final int xInMs;
    private final ImmutableList<String> names;
    private final UserData userData;

    ImmutablePojo(int xInMs, ImmutableList<String> names, UserData userData) {
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
        ImmutablePojo that = (ImmutablePojo) o;
        return xInMs == that.xInMs &&
            Objects.equals(names, that.names) &&
            Objects.equals(userData, that.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xInMs, names, userData);
    }
}
