package org.gem.musics.service;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Music;
import org.gem.musics.dto.music.MusicRequest;
import org.gem.musics.dto.music.MusicResponse;
import org.gem.musics.mapper.MusicMapper;
import org.gem.musics.repository.MusicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository repository;
    private final MusicMapper mapper;

    public MusicResponse addMusic(MusicRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public MusicResponse updMusic(MusicRequest req, Long id) throws NotFoundException{
        Music foundMsc = repository.findById(id).orElseThrow(() -> new NotFoundException("Music not found!", 404));
        Music music = mapper.toEntity(req);

        foundMsc.setArtistId(music.getArtistId());
        foundMsc.setDuration(music.getDuration());
        foundMsc.setGenre(music.getGenre());
        foundMsc.setTitle(music.getTitle());

        return mapper.toResponse(repository.save(foundMsc));
    }

    public MusicResponse getMusicById(Long id) throws NotFoundException{
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("Music not found!", 404)));
    }

    public List<MusicResponse> getAllMusics(){
        return mapper.toResponse(repository.findAll());
    }

    public HttpStatus delMusic(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

}
