package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.base.User;
import org.gem.musics.dto.user.UserResponse;
import org.gem.musics.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    @PostMapping
    public UserResponse addUser(@RequestBody User user){
        return null;
    }
    @PutMapping("/{id}")
    public UserResponse updUser(@RequestBody User user, @PathVariable Long id){
        return null;
    }
    @GetMapping
    public List<UserResponse> getAllUsers(){
        return null;
    }
    @GetMapping("/{id}")
    public UserResponse getByUserID(@RequestBody User user, @PathVariable Long id){
        return null;
    }
    @DeleteMapping("/{id}")
    public void dltUser(@PathVariable Long id){

    }
}



