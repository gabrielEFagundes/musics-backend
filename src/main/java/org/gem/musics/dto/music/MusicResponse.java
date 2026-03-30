package org.gem.musics.dto.music;

import org.gem.musics.domain.enums.Genre;
import org.gem.musics.domain.models.Artist;

public record MusicResponse(Long id, String title, Long artistId, int duration, Genre genre, String coverImageUrl) {
}
