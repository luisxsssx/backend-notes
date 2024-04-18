package com.api.notes.Service;

import com.api.notes.Model.NotesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    // CRUD operations
    // Save note
    NotesModel saveNote(NotesModel notesModel);

    // Read note
    List<NotesModel> fetchAllNotes();

    // Update note
    NotesModel updateNotes(NotesModel notesModel, Long noteId);

    // Delete note
    void deleteNoteById(Long noteId);
}