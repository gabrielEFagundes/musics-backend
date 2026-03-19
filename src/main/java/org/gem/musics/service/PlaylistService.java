package org.gem.musics.service;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistRequest;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.gem.musics.mapper.PlaylistMapper;
import org.gem.musics.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// TODO
public class PlaylistService {

    private final PlaylistRepository repository;
    private final PlaylistMapper mapper;

    public PlaylistResponse addPlaylist(PlaylistRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public PlaylistResponse updPlaylist(PlaylistRequest req, Long id) throws NotFoundException{
        Playlist foundPlay = repository.findById(id).orElseThrow(() -> new NotFoundException("Playlist not found!", 404));
        Playlist playlist = mapper.toEntity(req);

        foundPlay.setMusics(playlist.getMusics());
        foundPlay.setTitle(playlist.getTitle());
        foundPlay.setUserId(playlist.getUserId());

        return mapper.toResponse(repository.save(foundPlay));
    }

    public List<PlaylistResponse> getAllPlaylists(){
        return mapper.toResponse(repository.findAll());
    }

    public PlaylistResponse getPlaylistById(Long id) throws NotFoundException{
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("Playlist not found!", 404)));
    }

    public HttpStatus delPlaylist(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

}
