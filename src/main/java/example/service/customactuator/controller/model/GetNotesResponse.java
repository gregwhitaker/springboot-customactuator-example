package example.service.customactuator.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.service.customactuator.data.model.Note;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonPropertyOrder({
        "count",
        "notes"
})
public class GetNotesResponse {

    public static GetNotesResponse from(Collection<Note> notes) {
        Assert.notNull(notes, "Notes cannot be null");

        List<GetNoteResponse> noteResponses = new ArrayList<>();
        notes.forEach(note -> noteResponses.add(GetNoteResponse.from(note)));

        GetNotesResponse response = new GetNotesResponse();
        response.setCount(notes.size());
        response.setNotes(noteResponses);
        
        return response;
    }

    private int count;
    private Collection<GetNoteResponse> notes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Collection<GetNoteResponse> getNotes() {
        return notes;
    }

    public void setNotes(Collection<GetNoteResponse> notes) {
        this.notes = notes;
    }
}
