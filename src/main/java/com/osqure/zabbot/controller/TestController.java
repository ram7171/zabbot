package com.osqure.zabbot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osqure.zabbot.exception.ResourceNotFoundException;
import com.osqure.zabbot.model.TestDB;
import com.osqure.zabbot.repository.NoteRepository;

@RestController
@RequestMapping("/api")

public class TestController {

	@Autowired
    NoteRepository noteRepository;
	
	// Get All Notes	
	@RequestMapping(value="/notes", method=RequestMethod.GET)
	public List<TestDB> getAllNotes() {
	    return noteRepository.findAll();
	}
	
//	@PostMapping("/notes")
	@RequestMapping(value = "notes", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
	public TestDB createNote(@Valid @RequestBody TestDB note) {
	    return noteRepository.save(note);
	}
	
	@GetMapping("/notes/{id}")
	public TestDB getNoteById(@PathVariable(value = "id") Long noteId) {
	    return noteRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	// Update a Note
	@PutMapping("/notes/{id}")
	public TestDB updateNote(@PathVariable(value = "id") Long noteId,
	                                        @Valid @RequestBody TestDB noteDetails) {

	    TestDB note = noteRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    note.setTitle(noteDetails.getTitle());
	    note.setContent(noteDetails.getContent());

	    TestDB updatedNote = noteRepository.save(note);
	    return updatedNote;
	}
	
	// Delete a Note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
	    TestDB note = noteRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    noteRepository.delete(note);

	    return ResponseEntity.ok().build();
	}
}
