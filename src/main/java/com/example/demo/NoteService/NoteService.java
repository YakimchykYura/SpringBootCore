package com.example.demo.NoteService;

import com.example.demo.Entity.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class NoteService {
    private static Map<Long, Note> notes = new HashMap<>();

    public void addNote (Long id, String title, String content) {
        if (!notes.containsKey(id)) {
            Note newNote = new Note();
            newNote.setId(id);
            newNote.setTitle(title);
            newNote.setContent(content);
            notes.put(id, newNote);
            System.out.println("Note Add!");
        } else {
            System.out.println("Note with such id " + id + " already exist");
        }
    }
    public void updateNote(Long id, String title, String content) {
        if (notes.containsKey(id)) {
            Note getNote = notes.get(id);
            getNote.setContent(content);
            getNote.setTitle(title);
            System.out.println("Note Update!");
        } else {
            System.out.println("Note with id " + id + " not exist");
        }
    }
    public Note getById (Long id) {
        if (notes.containsKey(id)) {
            Iterator<Note> iterator = notes.values().iterator();
            while (iterator.hasNext()) {
                Note note = iterator.next();
                if (note.getId() == id) {
                    return note;
                }
            }
        }
        System.out.println("Note with id " + id + " not exist");
        return null;
    }
    public void deleteNote (Long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
            System.out.println("Note Delete!");
        }
    }
    public Map<Long, Note> getAllNotes() {
        return notes;
    }
}
