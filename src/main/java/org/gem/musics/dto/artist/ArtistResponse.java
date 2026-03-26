package org.gem.musics.dto.artist;

import java.sql.Date;
import java.time.LocalDateTime;

public record ArtistResponse(Long id, String name, LocalDateTime loginDate, String artisticName, Long monthlyListeners, String description) {
}
