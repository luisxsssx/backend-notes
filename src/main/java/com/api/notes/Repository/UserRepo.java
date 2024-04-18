package com.api.notes.Repository;

import com.api.notes.Model.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);
}