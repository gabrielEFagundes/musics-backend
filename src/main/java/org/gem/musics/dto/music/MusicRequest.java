package org.gem.musics.dto.music;

import org.gem.musics.domain.enums.Genre;
import org.gem.musics.domain.models.Artist;

public record MusicRequest(String title, Long artistId, int duration, Genre genre, String coverImageUrl) {
    public MusicRequest{
        if(coverImageUrl == null || coverImageUrl.isEmpty()) coverImageUrl = "https://placehold.co/800?text=Music+Cover&font=roboto";
    }
}
