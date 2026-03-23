package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Album;
import org.gem.musics.dto.album.AlbumRequest;
import org.gem.musics.dto.album.AlbumResponse;
import org.gem.musics.dto.album.AlbumSummaryResponse;
import org.gem.musics.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService service;

    @PostMapping
    public AlbumResponse addAlbum(@RequestBody AlbumRequest album){
        return service.addAlbum(album);
    }
    @PutMapping("/{id}")
    public AlbumResponse updAlbum(@RequestBody AlbumRequest album, @PathVariable Long id) throws NotFoundException {
        return service.updAlbum(album, id);
    }
    @GetMapping
    public List<AlbumSummaryResponse> getAllAlbum(){
        return service.getAllAlbum();
    }
    @GetMapping("/{id}")
    public AlbumResponse getByAlbumId(@PathVariable Long id) throws NotFoundException{
        return service.getAlbumById(id);
    }
    @DeleteMapping("/{id}")
    public HttpStatus dltAlbum(@PathVariable Long id){
        return service.delAlbum(id);
    }
}
