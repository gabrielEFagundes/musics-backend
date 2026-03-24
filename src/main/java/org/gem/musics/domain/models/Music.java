package org.gem.musics.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.gem.musics.domain.enums.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long artistId;
    private int duration;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Music(String title, Long artistId, int duration, Genre genre) {
        this.title = title;
        this.artistId = artistId;
        this.duration = duration;
        this.genre = genre;
    }
}
