package org.gem.musics.dto.music;

import org.gem.musics.domain.enums.Genre;
import org.gem.musics.domain.models.Artist;

public record MusicRequest(String title, Long artistId, int duration, Genre genre) {
}
