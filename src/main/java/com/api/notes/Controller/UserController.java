package com.api.notes.Controller;

import com.api.notes.JWT.JwtService;
import com.api.notes.Model.UserModel;
import com.api.notes.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    // Annotation
    @Autowired private UserService userService;

    // Read operation
    @GetMapping("usr")
    public List<UserModel> fetchUserList() {
        return userService.fetchAllUsers();
    }

    // Update operation
    @PutMapping("/usr/{id}")
    public UserModel userModel(@RequestBody UserModel userModel, @PathVariable("id") Long userId) {
        return userService.updateUser(userModel, userId);
    }

    // Delete operation
    @DeleteMapping("/dl/{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        userService.deleteUserById(userId);
        return "Deleted Successfully";
    }

}