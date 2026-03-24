package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.models.Artist;
import org.gem.musics.dto.artist.ArtistRequest;
import org.gem.musics.dto.artist.ArtistResponse;
import org.gem.musics.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService service;

    @PostMapping
    public ArtistResponse addArt(@RequestBody ArtistRequest art){
        return service.addArtist(art);
    }

    @PutMapping("/{id}")
    public ArtistResponse updArt(@RequestBody ArtistRequest art, @PathVariable Long id) throws Exception{
        return service.updArtist(art, id);
    }

    @GetMapping
    public List<ArtistResponse> getAllArt(){
        return service.getAllArtists();
    }

    @GetMapping("/{id}")
    public ArtistResponse getByArtId(@PathVariable Long id) throws Exception{
        return service.getArtistById(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus dltArt(@PathVariable Long id){
        return service.delArtist(id);
    }
}
