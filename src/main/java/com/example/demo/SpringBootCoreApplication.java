package com.example.demo;

import com.example.demo.Entity.Note;
import com.example.demo.NoteService.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);
		NoteService service = new NoteService();
		service.addNote(1L, "Yura", "Yakimchyk");
		Note getNote = service.getById(1L);
		System.out.println(getNote.getId() + getNote.getTitle() + getNote.getContent());
		service.updateNote(1L, "YURA", "YAKIMCHYK");
		service.deleteNote(1L);
		Map<Long, Note> allNotes = service.getAllNotes();
		allNotes.forEach((aLong, note) -> System.out.println("id " + aLong + " Note " + note));
	}

}
