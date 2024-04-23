package com.api.notes.Service;

import com.api.notes.JWT.JwtService;
import com.api.notes.Model.NotesModel;
import com.api.notes.Model.UserModel;
import com.api.notes.Repository.NoteRepo;
import com.api.notes.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired private JwtService jwtService;

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

    // Read
    @Override
    public List<NotesModel> fetchAllNotes(Long userId) {
        Optional<UserModel> userModelOptional = userRepo.findById(Math.toIntExact(userId));

        if(userModelOptional.isPresent()) {
            UserModel user = userModelOptional.get();
            return user.getNotes();
        } else {
            return Collections.emptyList();
        }
    }

    // Update Note
    @Override
    public NotesModel updateNotes(NotesModel notesModel, Long noteId, Long userId) {
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
    public void deleteNoteById(Long noteId, Long userId) {
        Optional<NotesModel> notesModelOptional = noteRepo.findById(Math.toIntExact(noteId));
        if(notesModelOptional.isPresent()) {
            NotesModel notesModel = notesModelOptional.get();
            if(notesModel.getUser().getUUID().equals(userId)) {
                noteRepo.deleteById(Math.toIntExact(noteId));
            } else {
                throw new UnsupportedOperationException("The note does not belong to the user");
            }
        }
    }
}