package org.gem.musics.mapper;

import org.gem.musics.domain.models.Album;
import org.gem.musics.dto.album.AlbumRequest;
import org.gem.musics.dto.album.AlbumResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumMapper {

    public Album toEntity(AlbumRequest req){
        return new Album(req.title(), req.releaseYear(), req.artist(), req.musics());
    }

    public AlbumResponse toResponse(Album a) {
        return new AlbumResponse(a.getId(), a.getTitle(), a.getReleaseYear(), a.getArtist(), a.getMusics());
    }

    public List<AlbumResponse> toResponse(List<Album> as){
        List<AlbumResponse> albums = new ArrayList<>();

        as.forEach(album -> {
            albums.add(toResponse(album));
        });

        return albums;
    }
}
