package Client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseObject {

    @JsonProperty
    public Facts[] all;
}
