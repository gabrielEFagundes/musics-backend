package org.gem.musics.mapper;

import org.gem.musics.domain.models.Music;
import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistRequest;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.gem.musics.dto.playlist.PlaylistSummaryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaylistMapper {

    public Playlist toEntity(PlaylistRequest req){
        return new Playlist(req.title(), req.userId());
    }

    public PlaylistResponse toResponse(Playlist p, List<Music> musics){
        return new PlaylistResponse(p.getId(), p.getTitle(), musics, p.getUserId());
    }

    public PlaylistSummaryResponse toSumResponse(Playlist p){
        return new PlaylistSummaryResponse(p.getId(), p.getTitle(), p.getUserId());
    }

    public List<PlaylistSummaryResponse> toSumResponse(List<Playlist> ps){
        List<PlaylistSummaryResponse> playlists = new ArrayList<>();

        ps.forEach(play -> {
            playlists.add(toSumResponse(play));
        });

        return playlists;
    }
}
