package Client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {

    @JsonProperty
    String first;
    @JsonProperty
    String last;

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
