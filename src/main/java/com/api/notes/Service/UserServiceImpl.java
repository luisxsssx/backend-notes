package com.api.notes.Service;

import com.api.notes.Model.UserModel;

import com.api.notes.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    // save operation
    /*@Override
    public UserModel saveUser(UserModel userModel) {
        return userRepo.save(userModel);
    }*/

    // read operation
    @Override
    public List<UserModel> fetchAllUsers() {
        return (List<UserModel>) userRepo.findAll();
    }


    // update operation
    @Override
    public UserModel updateUser(UserModel userModel, Long userId) {
        UserModel usrDB = userRepo.findById(Math.toIntExact(userId)).get();

        if(Objects.nonNull(userModel.getUsername()) && !"".equalsIgnoreCase(userModel.getUsername())) {
            usrDB.setUsername(userModel.getUsername());
        }

        if(Objects.nonNull(userModel.getFirst_name()) && !"".equalsIgnoreCase(userModel.getFirst_name())) {
            usrDB.setFirst_name(userModel.getFirst_name());
        }

        if(Objects.nonNull(userModel.getLast_name()) && !"".equalsIgnoreCase(userModel.getLast_name())) {
            usrDB.setLast_name(userModel.getLast_name());
        }

        if(Objects.nonNull(userModel.getEmail()) && !"".equalsIgnoreCase(userModel.getEmail())) {
            usrDB.setEmail(userModel.getEmail());
        }

        if(Objects.nonNull(userModel.getPassword()) && !"".equalsIgnoreCase(userModel.getPassword())) {
            usrDB.setPassword(userModel.getPassword());
        }

        return userRepo.save(usrDB);
    }

    // delete operation
    @Override
    public void deleteUserById(Long userId) {
        userRepo.deleteById(Math.toIntExact(userId));
    }
}