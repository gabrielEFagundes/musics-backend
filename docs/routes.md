## Routes

### /GET

#### Musics
```bash
/musics           # Gets all musics

/musics/{id}      # Get music by ID

/musics?genre={genre}  # Gets musics by the specified genre

/musics?name={name}    # Gets musics by name
```

#### Users
```bash
/users            # Get all users

/users/{id}       # Get user by ID

/users?type=artist     # Gets only artists
/users?type=listener   # Gets only users that have no musics posted

/users?name={name}     # Searches by the user's name
```

#### Playlist

```bash
/playlists              # Gets all playlists

/playlists/{id}         # Gets playlist by ID
```

#### Albums

```bash
/albums                 # Gets all albums

/albums/{id}            # Get album by ID

/albums?name={name}     # Searches by the album's name
```

---

### /POST

```bash
# Each adds to the model
/musics

/users

/playlists

/albums
```

---

### /PUT

```bash
# Each updates by id
/musics/{id}

/users/{id}

/playlists/{id}

/albums/{id}
```

---

### /DELETE

```bash
# Each deletes by id
/musics/{id}

/users/{id}

/playlists/{id}

/albums/{id}
```