package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PossibleTriangle {
    @JsonProperty("isPossible")
    private Boolean isPossible;

    public Boolean getIsPossible() {
        return isPossible;
    }

    public void setIsPossible(Boolean isPossible) {
        this.isPossible = isPossible;
    }
}
