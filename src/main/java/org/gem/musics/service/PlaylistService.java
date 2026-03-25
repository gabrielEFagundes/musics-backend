package org.gem.musics.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Music;
import org.gem.musics.domain.models.Playlist;
import org.gem.musics.dto.playlist.PlaylistRequest;
import org.gem.musics.dto.playlist.PlaylistResponse;
import org.gem.musics.dto.playlist.PlaylistSummaryResponse;
import org.gem.musics.mapper.PlaylistMapper;
import org.gem.musics.repository.MusicRepository;
import org.gem.musics.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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

    @Transactional
    public PlaylistResponse addMusicToPlaylist(Long playlistId, Long musicId) throws NotFoundException{
        if(!musicRepository.existsById(musicId)){
            throw new NotFoundException("Music doesn't exists!");
        }
        repository.saveToMusicsPlaylist(playlistId, musicId);

        Playlist p = repository.findById(playlistId).orElseThrow(() -> new NotFoundException("Playlist doesn't exists!"));
        List<Music> musicList = musicRepository.findAllById(repository.findMusicIdsByPlaylistId(playlistId));

        return mapper.toResponse(p, musicList);
    }

    @Transactional
    public void deleteMusicFromPlaylist(Long playlistId, Long musicId) throws NotFoundException {
        if(!musicRepository.existsById(musicId)){
            throw new NotFoundException("Music doesn't exists!");
        }
        repository.deleteMusicFromPlaylist(musicId, playlistId);
    }

    @Transactional
    public PlaylistResponse updPlaylist(PlaylistRequest req, Long id) throws NotFoundException{
        Playlist foundPlay = repository.findById(id).orElseThrow(() -> new NotFoundException("Playlist not found!"));
        Playlist playlist = mapper.toEntity(req);

        foundPlay.setTitle(playlist.getTitle());
        foundPlay.setUserId(playlist.getUserId());
        repository.save(foundPlay);

        if(!req.musicIds().isEmpty()) {
            repository.deleteByPlaylistId(id);
            req.musicIds().forEach(music -> {
                repository.saveToMusicsPlaylist(id, music);
            });
        }

        List<Music> musicList = musicRepository.findAllById(req.musicIds());
        return mapper.toResponse(foundPlay, musicList);
    }

    public List<PlaylistSummaryResponse> getAllPlaylists(){
        return mapper.toSumResponse(repository.findAll());
    }

    public PlaylistResponse getPlaylistById(Long id) throws NotFoundException{
        Playlist p = repository.findById(id).orElseThrow(() -> new NotFoundException("Playlist not found!"));

        List<Long> musicIds = repository.findMusicIdsByPlaylistId(p.getId());
        List<Music> musics = musicRepository.findAllById(musicIds);

        return mapper.toResponse(p, musics);
    }

    public List<PlaylistSummaryResponse> getPlaylistByName(String name) throws NotFoundException{
        return mapper.toSumResponse(repository.findByTitle(name));
    }

    public HttpStatus delPlaylist(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;
    }

}
