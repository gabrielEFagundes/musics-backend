package org.gem.musics.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.gem.musics.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final PlaylistService service;

    @PostMapping
    public PlaylistResponse addPlay(@RequestBody Playlist play){
        return null;
    }
    @PutMapping("/{id}")
    public PlaylistResponse updPlay(@RequestBody Playlist play, @PathVariable Long id){
        return null;
    }
    @GetMapping
    public List<PlaylistResponse> getAllPlayslists(@RequestBody Playlist play){
        return null;
    }
    @GetMapping("/{id}")
    public PlaylistResponse getByPlayId(@PathVariable Long id){
        return null;
    }
    @DeleteMapping("/{id}")
    public void dltPlay(@PathVariable Long id){

    }
}
