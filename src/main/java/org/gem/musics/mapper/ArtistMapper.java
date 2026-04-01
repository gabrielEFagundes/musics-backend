package org.gem.musics.mapper;

import org.gem.musics.domain.models.Artist;
import org.gem.musics.dto.artist.ArtistRequest;
import org.gem.musics.dto.artist.ArtistResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtistMapper {

    public Artist toEntity(ArtistRequest req){
        return new Artist(req.name(), req.email(), req.password(), req.profilePictureUrl(), req.artisticName(), req.monthlyListeners(), req.description());
    }

    public ArtistResponse toResponse(Artist a){
        return new ArtistResponse(a.getId(), a.getName(), a.getEmail(), a.getPassword(), a.getLoginDate(), a.getProfilePictureUrl(), a.getArtisticName(), a.getMonthlyListeners(), a.getDescription());
    }

    public List<ArtistResponse> toResponse(List<Artist> as){
        List<ArtistResponse> artists = new ArrayList<>();

        as.forEach(artist -> {
            artists.add(toResponse(artist));
        });

        return artists;
    }
}
