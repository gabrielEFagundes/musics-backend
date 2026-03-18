package org.gem.musics.domain.base;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    private Long id;
    private String name;
    private Date loginDate;

    public User( String name, Date loginDate) {
        this.name = name;
        this.loginDate = loginDate;
    }
}



