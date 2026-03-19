package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.models.Album;
import org.gem.musics.dto.album.AlbumResponse;
import org.gem.musics.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService service;

    @PostMapping
    public AlbumResponse addAlbum(@RequestBody Album album){
        return null;
    }
    @PutMapping("/{id}")
    public AlbumResponse updAlbum(@RequestBody Album album, @PathVariable Long id){
        return null;
    }
    @GetMapping
    public List<AlbumResponse> getAllAlbum(){
        return null;
    }
    @GetMapping("/{id}")
    public AlbumResponse getByAlbumId(@PathVariable Long id){
        return null;
    }
    @DeleteMapping("/{id}")
    public void dltAlbum(@PathVariable Long id){

    }
}
