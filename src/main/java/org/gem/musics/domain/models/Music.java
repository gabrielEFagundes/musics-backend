package org.gem.musics.domain.models;

import jakarta.persistence.Entity;
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
public class Music {
    private Long id;
    private String title;
    private Artist artist;
    private int duration;
    private Genre genre;
}
