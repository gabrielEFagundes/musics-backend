package org.gem.musics.domain.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.gem.musics.domain.base.User;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Artist extends User {

    private String artisticName;
    private Long monthlyListeners;
    private String description;

    public Artist(String name, Date loginDate, String artisticName, Long monthlyListeners, String description) {
        super(name, loginDate);
        this.artisticName = artisticName;
        this.monthlyListeners = monthlyListeners;
        this.description = description;
    }
}
