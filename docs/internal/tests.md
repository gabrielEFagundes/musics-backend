## User:

```json
{
  "name": "Gabriel",
}
```

## Artist:

```json
{
  "name": "Matheus",
  "artisticName": "gabsDaCoder",
  "monthlyListeners": 7919299,
  "description": "I'm sure there won't always be sunshine..."
}
```

## Musics:

```json
{
    "title": "Notion",
    "artistId": 2,
    "duration": 123,
    "genre": "POP"
}

{
  "title": "Sailor Song",
  "artistId": 2,
  "duration": 145,
  "genre": "CLASSIC_JAZZ"
}

{
  "title": "Goodbye to a World",
  "artistId": 2,
  "duration": 231,
  "genre": "ROCK"
}
```

## Playlists:

```json
{
    "title": "Sad Past",
    "userId": 1,
    "musicIds": [1, 2, 3]
}
```

## Albums:

```json
{
    "title": "Calming Notion",
    "releaseYear": 2026,
    "artistId": 2,
    "musicIds": [1,2,3]
}
```

# How it should work

- Users can register themselves through `/users`
- Artists can register themselves through `/artists`
- `GET /users` returns both normal users and artists - `GET /artists` returns only artists

---

- Musics can be registered at `/musics`
- Playlists cannot have unexistent musics
- Musics are added to playlists through their IDs
- `/GET playlists` returns all the playlists without the musics
- `/GET playlists/{id}` returns the specific playlist with all the musics

---

- Albums work basically the same as Musics
- `GET /albums` gets all the albums without their musics
- `GET /albums/{id}` gets the specific album with all their musics
- Musics should be added to the album with their IDs, just like Playlists

---

### Adding new musics to an album/playlist

In terms of adding musics to albums or playlists, we'll need a dedicated endpoint, which could be something like `POST /playlists/{id}/musics/{musidId}`

This would add a music to the specified playlist, instead of updating it everytime.

Thinking about it, we should even stop messing with the musics on the update and pass this task to the specified endpoint, that would make things way clearer and even faster, since it wouldn't have to remove and add all of the entries from the `musics_playlist` or `musics_album` every update.

Also:

- Trying to add musics that doesn't exist on the database does not work, simply nothing happens if you try.
  - Though we could return something like an error.

### Searching

The searching methods are quite confusing, but they can be sorted out pretty easily.

We have both `GET /playlists/{id}` and `GET /playlists/{name}`, same for albums.

The user will NEVER use the search by ID endpoint, we'll only use that endpoint for **showing the specific playlist/album to the user**, that by returning the playlist with its corresponding musics.

The user will simply search for the playlists or albums through the search by name endpoint, and when he clicks a playlist or album, it will enter on its page and show its information.

Hopefully this makes things clearer for all of us.