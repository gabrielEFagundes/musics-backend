package org.gem.musics.dto.user;

import java.time.LocalDate;

public record UserResponse(Long id, String name, LocalDate loginDate) {
}
