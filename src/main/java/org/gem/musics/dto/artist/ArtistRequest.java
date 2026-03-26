package org.gem.musics.dto.artist;

import java.sql.Date;
import java.time.LocalDateTime;

public record ArtistRequest(String name, LocalDateTime loginDate, String artisticName, Long monthlyListeners, String description) {
}
