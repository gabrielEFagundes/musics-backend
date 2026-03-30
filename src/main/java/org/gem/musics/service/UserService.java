package org.gem.musics.service;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.base.User;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.dto.user.UserRequest;
import org.gem.musics.dto.user.UserResponse;
import org.gem.musics.mapper.UserMapper;
import org.gem.musics.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponse addUser(UserRequest u){
        User user = mapper.toEntity(u);

        user.setLoginDate(LocalDate.now());
        return mapper.toResponse(repository.save(user));
    }

    public UserResponse updUser(UserRequest u, Long id) throws NotFoundException{
        User foundUsr = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!", 404));
        User user = mapper.toEntity(u);

        foundUsr.setName(user.getName());
        foundUsr.setLoginDate(user.getLoginDate());

        return mapper.toResponse(repository.save(foundUsr));
    }

    public List<UserResponse> getAllUsers(){
        return mapper.toResponse(repository.findAll());
    }

    public UserResponse getUserById(Long id) throws NotFoundException{
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!", 404)));
    }

    public UserResponse getUserByName(String name) throws NotFoundException{
        return mapper.toResponse(repository.findByName(name).orElseThrow(() -> new NotFoundException("User not found!", 404)));
    }

    public HttpStatus delUser(Long id){
        // very simple verification just for now
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

}
