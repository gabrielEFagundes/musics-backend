package org.gem.musics.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Music;
import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistRequest;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.gem.musics.mapper.PlaylistMapper;
import org.gem.musics.repository.MusicRepository;
import org.gem.musics.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// TODO
public class PlaylistService {

    private final PlaylistRepository repository;
    private final MusicRepository musicRepository;
    private final PlaylistMapper mapper;

    @Transactional
    public PlaylistResponse addPlaylist(PlaylistRequest req){
        Playlist p = repository.save(
                        mapper.toEntity(req));

        req.musicIds().forEach(music -> {
            repository.saveToMusicsPlaylist(p.getId(), music);
        });

        List<Music> musicList = musicRepository.findAllById(req.musicIds());

        return mapper.toResponse(p, musicList);
    }

    public PlaylistResponse updPlaylist(PlaylistRequest req, Long id) throws NotFoundException{
        Playlist foundPlay = repository.findById(id).orElseThrow(() -> new NotFoundException("Playlist not found!", 404));
        Playlist playlist = mapper.toEntity(req);

        foundPlay.setTitle(playlist.getTitle());
        foundPlay.setUserId(playlist.getUserId());

        List<Music> musicList = musicRepository.findAllById(req.musicIds());

        return mapper.toResponse(repository.save(foundPlay), musicList);
    }

    public List<PlaylistResponse> getAllPlaylists(){
        return mapper.toResponse(repository.findAll(), List.of());
    }

    public PlaylistResponse getPlaylistById(Long id) throws NotFoundException{
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("Playlist not found!", 404)), List.of());
    }

    public HttpStatus delPlaylist(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

}
