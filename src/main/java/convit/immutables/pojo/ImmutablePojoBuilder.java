package convit.immutables.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;

@JsonPOJOBuilder(withPrefix = "")
class ImmutablePojoBuilder {

    private int xInMs;
    private List<String> names = new ArrayList<>();
    private UserData userData;

    ImmutablePojoBuilder xInMs(int xInMs) {
        this.xInMs = xInMs;
        return this;
    }

    public ImmutablePojoBuilder names(List<String> names) {
        this.names = names;
        return this;
    }

    public ImmutablePojoBuilder userData(UserData userData) {
        this.userData = userData;
        return this;
    }

    public ImmutablePojo build() {
        return new ImmutablePojo(xInMs, ImmutableList.copyOf(names), userData);
    }

}
