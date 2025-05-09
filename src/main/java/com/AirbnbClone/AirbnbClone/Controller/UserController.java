package com.AirbnbClone.AirbnbClone.Controller;

import com.AirbnbClone.AirbnbClone.Entity.User;
import com.AirbnbClone.AirbnbClone.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired

    private UserService userService;

    @GetMapping
    public List<User> getallUsers()
    {
        return userService.getAllUsers();
    }

    //Creating a new user

    @PostMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long Id)
    {
        Optional<User> user = userService.getUserById(Id);
        return user.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    // delete the user from the DB

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }




}
