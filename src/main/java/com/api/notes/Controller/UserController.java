package com.api.notes.Controller;

import com.api.notes.Model.UserModel;
import com.api.notes.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // Annotation
    @Autowired private UserService userService;

    // Save operation
    @PostMapping("/saveUser")
    public UserModel saveUserModel(@Validated @RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    // Read operation
    @GetMapping("users")
    public List<UserModel> fetchUserList() {
        return userService.fetchAllUsers();
    }

    // Update operation
    @PutMapping("/users/{id}")
    public UserModel userModel(@RequestBody UserModel userModel, @PathVariable("id") Long userId) {
        return userService.updateUser(userModel, userId);
    }

    // Delete operation
    @DeleteMapping("/del_users/{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return "Deleted Successfully";
    }

}