package org.gem.musics.mapper;

import org.gem.musics.domain.base.User;
import org.gem.musics.dto.user.UserRequest;
import org.gem.musics.dto.user.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserRequest req){
        return new User(req.name());
    }

    public UserResponse toResponse(User u){
        return new UserResponse(u.getId(), u.getName(), u.getLoginDate());
    }

    public List<UserResponse> toResponse(List<User> us){
        List<UserResponse> users = new ArrayList<>();

        us.forEach(user -> {
            users.add(toResponse(user));
        });

        return users;
    }
}
