package com.api.notes.Service;

import com.api.notes.Model.NotesModel;
import com.api.notes.Model.UserModel;
import com.api.notes.Repository.NoteRepo;
import com.api.notes.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private UserRepo userRepo;

    // Save Note
    @Override
    public NotesModel saveNote(NotesModel notesModel, Long userId) {
        Optional<UserModel> optionalUserModel = userRepo.findById(Math.toIntExact(userId));
        if(optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            notesModel.setUser(userModel);
            return noteRepo.save(notesModel);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
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