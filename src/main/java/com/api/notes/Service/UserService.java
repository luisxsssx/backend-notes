package com.api.notes.Service;

import com.api.notes.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    // CRUD operations
    UserModel saveUser(UserModel userModel);
    List<UserModel> fetchAllUsers();

    UserModel updateUser(UserModel userModel);

    // update operation
    UserModel updateUser(UserModel userModel, Long userId);

    void deleteUserById(Long userId);
}