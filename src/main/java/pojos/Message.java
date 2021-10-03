package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("error")
    private String error;

    public String getError() {
        return error;
    }
}
