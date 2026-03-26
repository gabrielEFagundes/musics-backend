package org.gem.musics.dto.user;

import java.time.LocalDateTime;

public record UserResponse(Long id, String name, LocalDateTime loginDate) {
}
