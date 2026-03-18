package org.gem.musics.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.models.Music;
import org.gem.musics.dto.music.MusicReponse;
import org.gem.musics.service.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/musics")
public class MusicController {
    private final MusicService service;

    @PostMapping
    public MusicReponse addMsc(@RequestBody Music music){
        return null;
    }
    @PutMapping("/{id}")
    public MusicReponse updMsc(@RequestBody Music music, @PathVariable Long id){
        return null;
    }
    @GetMapping
    public List<MusicReponse> getAllMsc(){
        return null;
    }
    @GetMapping("/{id}")
    public MusicReponse getByMscId(@PathVariable Long id){
        return null;
    }
    @DeleteMapping("/{id}")
    public void dltMsc(@PathVariable Long id){

    }
}
