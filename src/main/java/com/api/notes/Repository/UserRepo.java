package com.api.notes.Repository;

import com.api.notes.Model.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserModel, Integer> {

}