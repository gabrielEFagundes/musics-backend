package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.models.Artist;
import org.gem.musics.dto.artist.ArtistResponse;
import org.gem.musics.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ArtistController {
    private final ArtistService service;

    @PostMapping
    public ArtistResponse addArt(@RequestBody Artist art){
        return null;
    }
    @PutMapping("/{id}")
    public ArtistResponse updArt(@RequestBody Artist art, @PathVariable Long id){
        return null;
    }
    @GetMapping
    public List<ArtistResponse> getAllArt(){
        return null;
    }
    @GetMapping("/{id}")
    public ArtistResponse getByArtId(@PathVariable Long id){
        return null;
    }
    @DeleteMapping("/{id}")
    public void dltArt(@PathVariable Long id){

    }
}
