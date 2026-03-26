package org.gem.musics.dto.user;

import java.time.LocalDateTime;

public record UserRequest(String name, LocalDateTime loginDate) {
}
