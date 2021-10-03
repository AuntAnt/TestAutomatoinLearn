package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NegativeResponse {
    @JsonProperty("message")
    private Message message;

    public Message getMessage() {
        return message;
    }
}
