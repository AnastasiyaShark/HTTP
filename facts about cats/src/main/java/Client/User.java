package Client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty
    String _id;
    @JsonProperty
    Name name;

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", name=" + name +
                '}';
    }
}
