package com.api.notes.Controller;

import com.api.notes.Model.NotesModel;
import com.api.notes.Service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    // Annotation
    @Autowired private NoteService noteService;

    // Save note
    @PostMapping("/saveNote")
    public NotesModel saveNoteModel(@Validated @RequestBody NotesModel notesModel) {
        return noteService.saveNote(notesModel);
    }

    // Read note
    @PostMapping("notes")
    public List<NotesModel> fetchNotesList() {
        return noteService.fetchAllNotes();
    }

    // Update note
    @PutMapping("/notes/{id}")
    public NotesModel notesModel(@RequestBody NotesModel notesModel, @PathVariable("id") Long notesId) {
        return noteService.updateNotes(notesModel, notesId);
    }

    // Delete note
    @DeleteMapping("/del_notes/{id}")
    public String delteNotesById(@PathVariable("id") Long notesId) {
        noteService.deleteNoteById(notesId);
        return "Deleted Successfully";
    }
}