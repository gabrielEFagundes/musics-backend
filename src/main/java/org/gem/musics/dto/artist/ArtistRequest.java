package org.gem.musics.dto.artist;

public record ArtistRequest(String name, String profilePictureUrl, String artisticName, Long monthlyListeners, String description) {
}