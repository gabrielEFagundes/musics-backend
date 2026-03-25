package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.dto.user.UserRequest;
import org.gem.musics.dto.user.UserResponse;
import org.gem.musics.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest user){
        return service.addUser(user);
    }

    @PutMapping("/{id}")
    public UserResponse updUser(@RequestBody UserRequest user, @PathVariable Long id) throws Exception{
        return service.updUser(user, id);
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/user")
    public UserResponse getUserByName(@RequestParam("name") String name) throws Exception{
        return service.getUserByName(name);
    }

    @GetMapping("/{id}")
    public UserResponse getByUserID(@PathVariable Long id) throws Exception {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus dltUser(@PathVariable Long id){
        return service.delUser(id);
    }
}



