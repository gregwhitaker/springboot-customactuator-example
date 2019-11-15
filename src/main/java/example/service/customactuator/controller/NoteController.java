package example.service.customactuator.controller;

import example.service.customactuator.controller.model.CreateNoteRequest;
import example.service.customactuator.controller.model.GetNoteResponse;
import example.service.customactuator.controller.model.GetNotesResponse;
import example.service.customactuator.data.NoteRepository;
import example.service.customactuator.data.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * Controller responsible for adding and deleting notes.
 */
@RestController
public class NoteController {
    private static final Logger LOG = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteRepository repo;

    @PostMapping(value = "/notes")
    public ResponseEntity<?> createNote(@RequestBody CreateNoteRequest request,
                                        UriComponentsBuilder uriBuilder) {
        Note note = repo.create(request.toNote());

        URI uri = uriBuilder.path("/notes/{id}")
                .buildAndExpand(note.getId())
                .toUri();

        return ResponseEntity.created(uri).body(note);
    }

    @GetMapping(value = "/notes")
    public ResponseEntity<?> getNotes() {
        return ResponseEntity.ok(GetNotesResponse.from(repo.findAll().values()));
    }

    @GetMapping(value = "/notes/{id}")
    public ResponseEntity<?> getNote(@PathVariable("id") long id) {
        Note note = repo.find(id);

        if (note != null) {
            return ResponseEntity.ok(GetNoteResponse.from(note));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") long id) {
        return null;
    }
}
