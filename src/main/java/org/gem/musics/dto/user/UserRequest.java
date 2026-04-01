package org.gem.musics.dto.user;

public record UserRequest(String name, String email, String password, String profilePictureUrl) {
    public UserRequest{
        if(profilePictureUrl == null || profilePictureUrl.isEmpty()) profilePictureUrl = "https://images.unsplash.com/vector-1742875355318-00d715aec3e8?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
    }
}