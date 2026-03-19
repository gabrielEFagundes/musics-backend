package org.gem.musics.dto.playlist;

import org.gem.musics.domain.base.User;
import org.gem.musics.domain.models.Music;

import java.util.List;

public record PlaylistRequest(String title, List<Long> musicIds, Long userId) {
}
