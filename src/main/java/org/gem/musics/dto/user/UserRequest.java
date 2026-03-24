package org.gem.musics.dto.user;

import java.sql.Date;

public record UserRequest(String name, Date loginDate) {
}
