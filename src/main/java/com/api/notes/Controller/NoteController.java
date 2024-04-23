package com.api.notes.Controller;

import com.api.notes.JWT.JwtService;
import com.api.notes.Model.NotesModel;
import com.api.notes.Model.UserModel;
import com.api.notes.Service.NoteService;

import com.api.notes.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<NotesModel> fetchNotesList() {
        return noteService.fetchAllNotes();
    }

    // Update note
    @PutMapping("/notes/{id}")
    public NotesModel updateNotes(@RequestBody NotesModel notesModel, @PathVariable("id") Long notesId, HttpServletRequest request)  {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token.substring(7));
        return noteService.updateNotes(notesModel, notesId, userId);
    }

    // Delete note
    @DeleteMapping("/del_notes/{id}")
    public String deleteNotesById(@PathVariable("id") Long notesId) {
        noteService.deleteNoteById(notesId);
        return "Deleted Successfully";
    }
}