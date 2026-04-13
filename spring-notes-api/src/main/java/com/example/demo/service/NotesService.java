package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Note;
import com.example.demo.repositories.NotesRepository;

@Service
public class NotesService {
	@Autowired
	NotesRepository notesRepository;
	public Iterable<Note>getNotes()
	{
		return notesRepository.findAll();
		}


//	public Note getNotes() {
//		Note note=new Note();
//		note.setId(1234);
//		note.setTitle("Test note title");
//		note.setContent("Test Note Content");
//		return note;
//	}

	public void createNote(Note note)
	{
//		System.out.println(note.getId());
//		System.out.println(note.getTitle());
//		
		notesRepository.save(note);
	}
	
}
