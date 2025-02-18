package com.crudapplication.react.springboot.Controller;

import com.crudapplication.react.springboot.Exception.UserNotFoundException;
import com.crudapplication.react.springboot.Model.User;
import com.crudapplication.react.springboot.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepo UserRepo;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return UserRepo.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return UserRepo.findAll();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id) {
        return UserRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return UserRepo.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return UserRepo.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!UserRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        UserRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
