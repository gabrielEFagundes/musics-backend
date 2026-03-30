package org.gem.musics.dto.playlist;

import org.gem.musics.domain.base.User;
import org.gem.musics.domain.models.Music;

import java.util.List;

public record PlaylistResponse(Long id, String title, List<Music> musics, Long userId, String coverImageUrl) {
}
