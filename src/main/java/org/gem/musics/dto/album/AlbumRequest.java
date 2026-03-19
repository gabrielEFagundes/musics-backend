package org.gem.musics.dto.album;

import org.gem.musics.domain.models.Artist;
import org.gem.musics.domain.models.Music;

import java.sql.Date;
import java.util.List;

public record AlbumRequest(String title, int releaseYear, Artist artist, List<Music> musics) {
}
