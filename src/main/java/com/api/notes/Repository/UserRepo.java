package com.api.notes.Repository;

import java.util.Optional;

import com.api.notes.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
    Optional<UserModel> findByUsername(String username);
}