package org.gem.musics.domain.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Column(name = "created_at")
    private LocalDate loginDate;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    public User(String name, String email, String password, String profilePictureUrl) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePictureUrl = profilePictureUrl;
    }
}



