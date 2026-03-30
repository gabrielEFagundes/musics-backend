package org.gem.musics.repository;

import org.gem.musics.domain.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Modifying
    @Query(value = "INSERT INTO musics_album (id_album, id_music) VALUES (:albumId, :musicId)", nativeQuery = true)
    void saveToMusicsAlbum(@Param("albumId") Long albumId, @Param("musicId") Long musicId);

    @Modifying
    @Query(value = "DELETE FROM musics_album WHERE id_music = :idMusic AND id_album = :idAlbum", nativeQuery = true)
    void deleteMusicFromAlbum(@Param("idMusic") Long idMusic, @Param("idAlbum") Long idAlbum);

    @Query(value = "SELECT id_music FROM musics_album WHERE id_album = :albumId", nativeQuery = true)
    List<Long> findMusicIdsByAlbumId(@Param("albumId") Long id);

    @Modifying
    @Query(value = "DELETE FROM musics_album WHERE id_album = :albumId", nativeQuery = true)
    void deleteByAlbumId(@Param("albumId") Long albumId);

    List<Album> findByTitle(String title);
}
