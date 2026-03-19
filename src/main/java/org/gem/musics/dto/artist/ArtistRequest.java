package org.gem.musics.dto.artist;

import java.sql.Date;

public record ArtistRequest(String name, Date loginDate, String artisticName, Long monthlyListeners, String description) {
}
