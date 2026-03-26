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
    private Long artistId;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    public Album(String title, int releaseYear, Long artistId) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
    }
}
