package org.gem.musics.service;

import lombok.RequiredArgsConstructor;
import org.gem.musics.domain.exceptions.NotFoundException;
import org.gem.musics.domain.models.Album;
import org.gem.musics.dto.album.AlbumRequest;
import org.gem.musics.dto.album.AlbumResponse;
import org.gem.musics.mapper.AlbumMapper;
import org.gem.musics.repository.AlbumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository repository;
    private final AlbumMapper mapper;

    public AlbumResponse addAlbum(AlbumRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public AlbumResponse updAlbum(AlbumRequest req, Long id) throws NotFoundException{
        Album foundAlbum = repository.findById(id).orElseThrow(() -> new NotFoundException("Album not found!", 404));
        Album album = mapper.toEntity(req);

        foundAlbum.setArtist(album.getArtist());
        foundAlbum.setTitle(album.getTitle());
        foundAlbum.setMusics(album.getMusics());

        return mapper.toResponse(repository.save(foundAlbum));
    }

    public List<AlbumResponse> getAllAlbum(){
        return mapper.toResponse(repository.findAll());
    }

    public AlbumResponse getAlbumById(Long id) throws NotFoundException{
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new NotFoundException("Album not found", 404)));
    }

    public HttpStatus delAlbum(Long id){
        repository.deleteById(id);

        if(repository.existsById(id)){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
