package org.gem.musics.repository;

import org.gem.musics.domain.base.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
