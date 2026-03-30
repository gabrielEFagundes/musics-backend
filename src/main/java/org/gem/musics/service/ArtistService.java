package org.gem.musics.service;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Artist;
import org.gem.musics.dto.artist.ArtistRequest;
import org.gem.musics.dto.artist.ArtistResponse;
import org.gem.musics.mapper.ArtistMapper;
import org.gem.musics.repository.ArtistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository repository;
    private final ArtistMapper mapper;

    public ArtistResponse addArtist(ArtistRequest req){
        Artist a = mapper.toEntity(req);

        a.setLoginDate(LocalDate.now());
        return mapper.toResponse(repository.save(a));
    }

    public ArtistResponse updArtist(ArtistRequest req, Long id) throws NotFoundException{
        Artist foundArt = repository.findById(id).orElseThrow(() -> new NotFoundException("Artist not found!"));
        Artist artist = mapper.toEntity(req);

        foundArt.setName(artist.getName());
        foundArt.setLoginDate(artist.getLoginDate());
        foundArt.setDescription(artist.getDescription());
        foundArt.setArtisticName(artist.getArtisticName());
        foundArt.setMonthlyListeners(artist.getMonthlyListeners());

        return mapper.toResponse(repository.save(foundArt));
    }

    public ArtistResponse getArtistById(Long id) throws NotFoundException{
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("Artist not found!")));
    }

    public List<ArtistResponse> getAllArtists(){
        return mapper.toResponse(repository.findAll());
    }

    public HttpStatus delArtist(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

}
