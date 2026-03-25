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
    public PlaylistResponse addMusicToPlaylist(@PathVariable Long id, @PathVariable Long musicId) throws Exception {
        return service.addMusicToPlaylist(id, musicId);
    }

    @DeleteMapping("/{id}/musics/{musicId}")
    public void deleteMusicFromPlaylist(@PathVariable Long id, @PathVariable Long musicId) throws Exception {
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

    /* TODO:
        we have to sort a way of getting the values that are approximated to the user's query,
        so if they search, for example, "Sad p", it should return all of the playlists with a similar combination of characters.
        @gabrielEFagundes and @Matheus089107 are responsible for this.
     */
    @GetMapping("/playlist")
    public List<PlaylistSummaryResponse> getByPlaylistName(@RequestParam("title") String name) throws Exception {
        return service.getPlaylistByName(name);
    }

    @DeleteMapping("/{id}")
    public HttpStatus dltPlay(@PathVariable Long id){
        return service.delPlaylist(id);
    }
}
