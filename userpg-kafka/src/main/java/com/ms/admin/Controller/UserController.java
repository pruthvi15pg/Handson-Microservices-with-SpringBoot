package com.ms.userpg.Controller;


import com.ms.userpg.Entity.User;
import com.ms.userpg.Exception.UserNotFoundException;
import com.ms.userpg.Model.UserRequest;
import com.ms.userpg.Repository.UserRepository;
import com.ms.userpg.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userpg")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity<String> registerNewUser(@RequestBody  @Valid UserRequest userRequest,HttpServletRequest req) {

        userService.saveUser(userRequest,req);
         return ResponseEntity.ok("User created successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException {
        List<User> allUsers=userRepository.findAll();
        if(allUsers.isEmpty()){
            throw new UserNotFoundException("No Users Found");
        }
        return new ResponseEntity<>(allUsers, HttpStatus.FOUND);
    }

    @PutMapping("/")
    public User updateUser(@PathVariable long id, @RequestBody UserRequest userRequest) {

            try {
                return userService.updateProduct(id, userRequest);
            } catch (Exception e) {
                e.getMessage();
            }
            return new User();
        }
    }





