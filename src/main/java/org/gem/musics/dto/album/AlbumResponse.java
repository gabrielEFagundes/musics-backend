package org.gem.musics.dto.album;

import org.gem.musics.domain.models.Artist;
import org.gem.musics.domain.models.Music;

import java.sql.Date;
import java.util.List;

public record AlbumResponse(Long id, String title, int releaseYear, Long artistId, List<Music> musics) {
}
