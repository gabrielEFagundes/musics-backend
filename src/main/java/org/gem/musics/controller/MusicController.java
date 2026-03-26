package org.gem.musics.controller;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.models.Music;
import org.gem.musics.dto.music.MusicRequest;
import org.gem.musics.dto.music.MusicResponse;
import org.gem.musics.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/musics")
public class MusicController {
    private final MusicService service;

    @PostMapping
    public MusicResponse addMsc(@RequestBody MusicRequest music){
        return service.addMusic(music);
    }

    @PutMapping("/{id}")
    public MusicResponse updMsc(@RequestBody MusicRequest music, @PathVariable Long id) throws Exception{
        return service.updMusic(music, id);
    }

    @GetMapping
    public List<MusicResponse> getAllMsc(){
        return service.getAllMusics();
    }

    @GetMapping("/{id}")
    public MusicResponse getByMscId(@PathVariable Long id) throws Exception{
        return service.getMusicById(id);
    }

    @GetMapping("/music")
    public MusicResponse getByMscName(@RequestParam("title") String name) throws Exception{
        return service.getMusicByName(name);
    }

    @DeleteMapping("/{id}")
    public HttpStatus dltMsc(@PathVariable Long id){
        return service.delMusic(id);
    }
}
