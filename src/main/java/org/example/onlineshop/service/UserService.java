package org.example.onlineshop.service;

import org.example.onlineshop.dto.UserDto;
import org.example.onlineshop.model.Result;
import org.example.onlineshop.model.User;
import org.example.onlineshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //CREATE
    public Result createUser(UserDto userDto){
        boolean exists = userRepository.existsByEmail(userDto.getEmail());
        if(exists){
            return new Result(false, "Email Already Exists");
        }

        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new Result(true,"User created successfully");
    }

    //READ
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //READ By ID
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    //UPDATE
    public Result editUser(String email, UserDto userDto){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            return new Result(true,"User updated successfully");
        }
        return new Result(false,"User Not Found");
    }

    //UPDATE Firstname and Lastname
    //UPDATE Password
    //CHANGE Email

    //DELETE
    public Result deleteUser(String email){
        boolean exists = userRepository.existsByEmail(email);
        if(exists){
            userRepository.deleteByEmail(email);
            return new Result(true,"User deleted successfully");
        }
        return new Result(false,"User Not Found");
    }
}
