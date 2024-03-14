package com.api.transportservices.services;

import com.api.transportservices.models.UserModel;
import com.api.transportservices.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository UserRepository;

    public ArrayList<UserModel> getUser(){
        return  (ArrayList<UserModel>) UserRepository.findAll();
    };

    public UserModel save(UserModel UserModel){
        return UserRepository.save(UserModel);
    }

    public Optional<UserModel> getById(Long id){
        return UserRepository.findById(id);
    }

    public UserModel updateById( UserModel request, Long id){

        UserModel userModel = UserRepository.findById(id).get();

        userModel.setName(request.getName());


        return userModel;
    }

    public Boolean delete(Long id){
        try {
            UserRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
