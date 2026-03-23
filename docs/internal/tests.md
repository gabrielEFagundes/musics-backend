## User:

```json
{
  "name": "Gabriel",
  "loginDate": "2026-03-23"
}
```

## Artist:

```json
{
  "name": "Matheus",
  "loginDate": "2026-03-23",
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