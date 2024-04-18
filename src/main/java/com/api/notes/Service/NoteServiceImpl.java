package com.api.notes.Service;

import com.api.notes.Model.NotesModel;
import com.api.notes.Repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    // Save Note
    @Override
    public NotesModel saveNote(NotesModel notesModel) {
        return noteRepo.save(notesModel);
    }

    // Read Note
    @Override
    public List<NotesModel> fetchAllNotes() {
        return (List<NotesModel>)noteRepo.findAll();
    }

    // Update Note
    @Override
    public NotesModel updateNotes(NotesModel notesModel, Long noteId) {
        NotesModel noteDB = noteRepo.findById(Math.toIntExact(noteId)).get();

        if(Objects.nonNull(notesModel.getTitle()) && !"".equalsIgnoreCase(notesModel.getTitle())) {
            noteDB.setTitle(notesModel.getTitle());
        }

        if(Objects.nonNull(notesModel.getNoteBody()) && !"".equalsIgnoreCase(notesModel.getNoteBody())) {
            noteDB.setNoteBody(notesModel.getNoteBody());
        }

        return noteRepo.save(noteDB);
    }

    // Delete Note
    @Override
    public void deleteNoteById(Long noteId) {
        noteRepo.deleteById(Math.toIntExact(noteId));
    }
}