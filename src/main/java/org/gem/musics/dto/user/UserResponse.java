package org.gem.musics.dto.user;

import java.sql.Date;

public record UserResponse(Long id, String name, Date loginDate) {
}
