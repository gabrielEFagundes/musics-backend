package org.gem.musics.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Album;
import org.gem.musics.domain.models.Music;
import org.gem.musics.dto.album.AlbumRequest;
import org.gem.musics.dto.album.AlbumResponse;
import org.gem.musics.dto.album.AlbumSummaryResponse;
import org.gem.musics.mapper.AlbumMapper;
import org.gem.musics.repository.AlbumRepository;
import org.gem.musics.repository.MusicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository repository;
    private final MusicRepository musicRepository;
    private final AlbumMapper mapper;

    @Transactional
    public AlbumResponse addAlbum(AlbumRequest req){
        Album a = repository.save(mapper.toEntity(req));

        req.musicIds().forEach(music -> {
            repository.saveToMusicsAlbum(a.getId(), music);
        });

        List<Music> musicList = musicRepository.findAllById(req.musicIds());

        return mapper.toResponse(a, musicList);
    }

    @Transactional
    public AlbumResponse addMusicToAlbum(Long albumId, Long musicId) throws NotFoundException {
        if(musicRepository.existsById(musicId)){
            throw new NotFoundException("Music doesn't exists!");
        }
        repository.saveToMusicsAlbum(albumId, musicId);

        Album a = repository.findById(albumId).orElseThrow(() -> new NotFoundException("Album doesn't exists!"));
        List<Music> musicList = musicRepository.findAllById(repository.findMusicIdsByAlbumId(musicId));

        return mapper.toResponse(a, musicList);
    }

    @Transactional
    public void deleteMusicFromAlbum(Long albumId, Long musicId) throws NotFoundException {
        if(!musicRepository.existsById(musicId)){
            throw new NotFoundException("Music doesn't exists!");
        }
        repository.deleteMusicFromAlbum(musicId, albumId);
    }

    @Transactional
    public AlbumResponse updAlbum(AlbumRequest req, Long id) throws NotFoundException{
        Album foundAlbum = repository.findById(id).orElseThrow(() -> new NotFoundException("Album not found!"));
        Album album = mapper.toEntity(req);

        foundAlbum.setArtistId(album.getArtistId());
        foundAlbum.setTitle(album.getTitle());
        repository.save(foundAlbum);

        if(!req.musicIds().isEmpty()) {
            repository.deleteByAlbumId(id);
            req.musicIds().forEach(music -> {
                repository.saveToMusicsAlbum(id, music);
            });
        }

        List<Music> musicList = musicRepository.findAllById(req.musicIds());
        return mapper.toResponse(foundAlbum, musicList);
    }

    public List<AlbumSummaryResponse> getAllAlbum(){
        return mapper.toResponse(repository.findAll());
    }

    public List<AlbumSummaryResponse> getAlbumByName(String name) throws NotFoundException{
        return mapper.toResponse(repository.findByTitle(name));
    }

    public AlbumResponse getAlbumById(Long id) throws NotFoundException{
        Album a = repository.findById(id).orElseThrow(() -> new NotFoundException("Album not found"));

        List<Long> musicIds = repository.findMusicIdsByAlbumId(a.getId());
        List<Music> musics = musicRepository.findAllById(musicIds);

        return mapper.toResponse(a, musics);
    }

    public HttpStatus delAlbum(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
