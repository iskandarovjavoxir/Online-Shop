package org.example.onlineshop.controller;

import org.example.onlineshop.dto.UserDto;
import org.example.onlineshop.model.Result;
import org.example.onlineshop.model.User;
import org.example.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public Result createUser(UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserByEmail(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user).getBody();
    }

    @PutMapping("/{email}")
    public Result updateUser(@PathVariable String email, @RequestBody UserDto userDto){
        return userService.editUser(email,userDto);
    }

    @DeleteMapping("/{email}")
    public Result deleteUser(@PathVariable String email){
        return userService.deleteUser(email);
    }
}
