package org.gem.musics.dto.artist;

public record ArtistRequest(String name, String email, String password, String profilePictureUrl, String artisticName, Long monthlyListeners, String description) {
}