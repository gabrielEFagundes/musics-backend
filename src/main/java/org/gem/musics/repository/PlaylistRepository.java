package org.gem.musics.repository;

import org.gem.musics.domain.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    @Modifying
    @Query(value = "INSERT INTO musics_playlist (id_playlist, id_music) VALUES (:idPlaylist, :idMusic)", nativeQuery = true)
    void saveToMusicsPlaylist(@Param("idPlaylist") Long idPlaylist, @Param("idMusic") Long idMusic);

    @Query(value = "SELECT id_music FROM musics_playlist WHERE id_playlist = :playlistId", nativeQuery = true)
    List<Long> findMusicIdsByPlaylistId(@Param("playlistId") Long playlistId);

    @Modifying
    @Query(value = "DELETE FROM musics_playlist WHERE id_playlist = :playlistId", nativeQuery = true)
    void deleteByPlaylistId(@Param("playlistId") Long playlistId);
}
