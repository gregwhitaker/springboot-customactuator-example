package example.service.customactuator.actuator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNoteCountResponse {

    @JsonProperty("note_count")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
