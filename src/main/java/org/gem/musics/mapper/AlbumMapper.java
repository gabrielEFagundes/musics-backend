package org.gem.musics.mapper;

import org.gem.musics.domain.models.Album;
import org.gem.musics.domain.models.Music;
import org.gem.musics.dto.album.AlbumRequest;
import org.gem.musics.dto.album.AlbumResponse;
import org.gem.musics.dto.album.AlbumSummaryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumMapper {

    public Album toEntity(AlbumRequest req){
        return new Album(req.title(), req.releaseYear(), req.artistId(), req.coverImageUrl());
    }

    public AlbumResponse toResponse(Album a, List<Music> ms) {
        return new AlbumResponse(a.getId(), a.getTitle(), a.getReleaseYear(), a.getArtistId(), ms, a.getCoverImageUrl());
    }

    public AlbumSummaryResponse toSumResponse(Album a){
        return new AlbumSummaryResponse(a.getId(), a.getTitle(), a.getReleaseYear(), a.getArtistId(), a.getCoverImageUrl());
    }

    public List<AlbumSummaryResponse> toResponse(List<Album> as){
        List<AlbumSummaryResponse> albums = new ArrayList<>();

        as.forEach(album -> {
            albums.add(toSumResponse(album));
        });

        return albums;
    }
}
