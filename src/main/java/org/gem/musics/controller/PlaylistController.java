package org.gem.musics.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistRequest;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.gem.musics.dto.playlist.PlaylistSummaryResponse;
import org.gem.musics.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final PlaylistService service;

    @PostMapping
    public PlaylistResponse addPlay(@RequestBody PlaylistRequest play){
        return service.addPlaylist(play);
    }

    @PostMapping("/{id}/musics/{musicId}")
    public void addMusicToPlaylist(@PathVariable Long id, @PathVariable Long musicId){
        service.addMusicToPlaylist(id, musicId);
    }

    @DeleteMapping("/{id}/musics/{musicId}")
    public void deleteMusicFromPlaylist(@PathVariable Long id, @PathVariable Long musicId){
        service.deleteMusicFromPlaylist(id, musicId);
    }

    @PutMapping("/{id}")
    public PlaylistResponse updPlay(@RequestBody PlaylistRequest play, @PathVariable Long id) throws Exception {
        return service.updPlaylist(play, id);
    }

    @GetMapping
    public List<PlaylistSummaryResponse> getAllPlayslists(){
        return service.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public PlaylistResponse getByPlayId(@PathVariable Long id) throws Exception {
        return service.getPlaylistById(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus dltPlay(@PathVariable Long id){
        return service.delPlaylist(id);
    }
}
