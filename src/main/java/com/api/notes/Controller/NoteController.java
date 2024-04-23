package com.api.notes.Controller;

import com.api.notes.JWT.JwtService;
import com.api.notes.Model.NotesModel;
import com.api.notes.Service.NoteService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    // Annotation
    @Autowired private NoteService noteService;
    @Autowired private JwtService jwtService;

    // Save note
    @PostMapping("/saveNote")
    public NotesModel saveNoteModel(@Validated @RequestBody NotesModel notesModel, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token.substring(7));
        return noteService.saveNote(notesModel, userId);
    }

    // Read note
    @GetMapping("notes")
    public List<NotesModel> fetchNotesList(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token.substring(7));
        return noteService.fetchAllNotes(userId);

    }

    // Update note
    @PutMapping("/notes/{id}")
    public NotesModel updateNotes(@RequestBody NotesModel notesModel, @PathVariable("id") Long notesId, HttpServletRequest request)  {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token.substring(7));
        return noteService.updateNotes(notesModel, notesId, userId);
    }

    // Delete note
    @DeleteMapping("/dl/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long noteId, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token.substring(7));
        noteService.deleteNoteById(noteId, userId);
        return ResponseEntity.ok("Note deleted successfully");
    }

}