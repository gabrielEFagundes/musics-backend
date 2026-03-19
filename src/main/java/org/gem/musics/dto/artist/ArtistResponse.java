package org.gem.musics.dto.artist;

import java.sql.Date;

public record ArtistResponse(Long id, String name, Date loginDate, String artisticName, Long monthlyListeners, String description) {
}
