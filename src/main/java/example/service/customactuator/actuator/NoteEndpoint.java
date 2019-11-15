package example.service.customactuator.actuator;

import example.service.customactuator.actuator.model.GetNoteCountResponse;
import example.service.customactuator.data.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Custom actuator endpoint for monitoring and managing the notes repository.
 */
@Component
@RestControllerEndpoint(id = "notes")
public class NoteEndpoint {

    @Autowired
    private NoteRepository repo;

    @DeleteMapping
    public ResponseEntity<?> clearNotes() {
        repo.clear();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<?> getNoteCount() {
        int count = repo.findAll().size();

        GetNoteCountResponse response = new GetNoteCountResponse();
        response.setCount(count);

        return ResponseEntity.ok(response);
    }
}
