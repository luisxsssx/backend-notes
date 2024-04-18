package com.api.notes.Repository;

import com.api.notes.Model.NotesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends CrudRepository<NotesModel, Integer> {
}