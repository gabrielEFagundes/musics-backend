package org.gem.musics.dto.user;

import java.time.LocalDate;

public record UserResponse(Long id, String name, String email, String password, LocalDate loginDate, String profilePictureUrl) {
}
