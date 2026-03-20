package org.gem.musics.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany
    @JoinColumn(name = "id_album")
    private List<Music> musics;

    public Album(String title, int releaseYear, Artist artist, List<Music> musics) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.musics = musics;
    }
}
