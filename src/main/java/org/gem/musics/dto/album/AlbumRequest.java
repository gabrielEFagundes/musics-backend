package org.gem.musics.dto.album;

import java.util.List;

public record AlbumRequest(String title, int releaseYear, Long artistId, List<Long> musicIds, String coverImageUrl) {
    public AlbumRequest {
        if(musicIds == null) musicIds = List.of();
        if(coverImageUrl == null || coverImageUrl.isEmpty()) coverImageUrl = "https://placehold.co/800?text=Album+Cover&font=roboto";
    }
}
