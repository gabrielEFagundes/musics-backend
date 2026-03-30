package org.gem.musics.dto.playlist;

import org.gem.musics.domain.base.User;
import org.gem.musics.domain.models.Music;

import java.util.List;

public record PlaylistRequest(String title, List<Long> musicIds, Long userId, String coverImageUrl) {
    public PlaylistRequest {
        if(musicIds == null) musicIds = List.of();
        if(coverImageUrl == null || coverImageUrl.isEmpty()) coverImageUrl = "https://placehold.co/800?text=Playlist+Cover&font=roboto";
    }
}
