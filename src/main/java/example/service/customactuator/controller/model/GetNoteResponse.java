package example.service.customactuator.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.service.customactuator.data.model.Note;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;

@JsonPropertyOrder({
        "id",
        "createDate",
        "title",
        "text"
})
public class GetNoteResponse {

    public static GetNoteResponse from(Note note) {
        Assert.notNull(note, "Note cannot be null");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

        GetNoteResponse response = new GetNoteResponse();
        response.setId(note.getId());
        response.setCreateDate(sdf.format(note.getCreateDate()));
        response.setTitle(note.getTitle());
        response.setText(note.getText());

        return response;
    }

    private long id;
    @JsonProperty("create_date")
    private String createDate;
    private String title;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
