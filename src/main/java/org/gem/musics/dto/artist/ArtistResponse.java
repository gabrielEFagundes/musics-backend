package org.gem.musics.dto.artist;

import java.time.LocalDate;

public record ArtistResponse(Long id, String name, String email, String password, LocalDate loginDate, String profilePictureUrl, String artisticName, Long monthlyListeners, String description) {
}