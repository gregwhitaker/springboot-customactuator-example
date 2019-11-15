package example.service.customactuator.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.service.customactuator.data.model.Note;

@JsonPropertyOrder({
        "title",
        "text"
})
public class CreateNoteRequest {

    private String title;
    private String text;

    public Note toNote() {
        Note note = new Note();
        note.setText(getText());
        note.setTitle(getTitle());

        return note;
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
