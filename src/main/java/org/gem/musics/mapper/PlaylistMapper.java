package org.gem.musics.mapper;

import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistRequest;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaylistMapper {

    public Playlist toEntity(PlaylistRequest req){
        return new Playlist(req.title(), req.musicIds(), req.userId());
    }

    public PlaylistResponse toResponse(Playlist p){
        return new PlaylistResponse(p.getId(), p.getTitle(), p.getMusics(), p.getUserId());
    }

    public List<PlaylistResponse> toResponse(List<Playlist> ps){
        List<PlaylistResponse> playlists = new ArrayList<>();

        ps.forEach(play -> {
            playlists.add(toResponse(play));
        });

        return playlists;
    }
}
