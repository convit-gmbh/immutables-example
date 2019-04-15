package convit.immutables.pojo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class UserData {

    private final String data;

    @JsonCreator
    public UserData(@JsonProperty("data") String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        UserData userData = (UserData) o;
        return Objects.equals(data, userData.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
