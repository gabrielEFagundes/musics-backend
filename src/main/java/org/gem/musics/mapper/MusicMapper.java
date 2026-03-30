package org.gem.musics.mapper;

import org.gem.musics.domain.models.Music;
import org.gem.musics.dto.music.MusicRequest;
import org.gem.musics.dto.music.MusicResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicMapper {

    public Music toEntity(MusicRequest req){
        return new Music(req.title(), req.artistId(), req.duration(), req.genre(), req.coverImageUrl());
    }

    public MusicResponse toResponse(Music m){
        return new MusicResponse(m.getId(), m.getTitle(), m.getArtistId(), m.getDuration(), m.getGenre(), m.getCoverImageUrl());
    }

    public List<MusicResponse> toResponse(List<Music> ms){
        List<MusicResponse> musics = new ArrayList<>();

        ms.forEach(music -> {
            musics.add(toResponse(music));
        });

        return musics;
    }
}
