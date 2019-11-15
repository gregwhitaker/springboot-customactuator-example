package example.service.customactuator.data;

import example.service.customactuator.data.model.Note;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class NoteRepository {
    private final AtomicLong counter = new AtomicLong(0);
    private final Map<Long, Note> notes = new ConcurrentHashMap<>();

    public Map<Long, Note> findAll() {
        return Collections.unmodifiableMap(notes);
    }

    public Note find(long id) {
        return notes.get(id);
    }

    public Note create(Note note) {
        note.setId(counter.incrementAndGet());
        note.setCreateDate(new Date());

        notes.put(note.getId(), note);

        return note;
    }

    public void delete(Note note) {
        notes.remove(note.getId());
    }
}
