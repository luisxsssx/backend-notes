package com.api.notes.Service;

import com.api.notes.Model.NotesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    // CRUD operations
    // Save note
    NotesModel saveNote(NotesModel notesModel, Long userId);

    // Read note
    List<NotesModel> fetchAllNotes(Long userId);

    // Update note
    NotesModel updateNotes(NotesModel notesModel, Long noteId, Long userId);

    // Delete note
    void deleteNoteById(Long noteId, Long userId);
}