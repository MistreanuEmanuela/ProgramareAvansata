
CREATE TABLE genres_import (
  name VARCHAR(255) PRIMARY KEY
);
CREATE TABLE subgenres_import (
  name VARCHAR(255) PRIMARY KEY
);
CREATE TABLE albums_import (
  id INT PRIMARY KEY,
  year INT,
  title VARCHAR(255),
  artist_id int,
  FOREIGN KEY (artist_id) REFERENCES artists_import(id)
);

CREATE TABLE album_genres_import (
  album_id INT,
  genre_name VARCHAR(255),
  PRIMARY KEY (album_id, genre_name),
  FOREIGN KEY (album_id) REFERENCES albums_import(id),
  FOREIGN KEY (genre_name) REFERENCES genres_import(name)
);
CREATE TABLE album_subgenres_import (
  album_id INT,
  genre_name VARCHAR(255),
  PRIMARY KEY (album_id, genre_name),
  FOREIGN KEY (album_id) REFERENCES albums_import(id),
  FOREIGN KEY (genre_name) REFERENCES subgenres_import(name)
);
CREATE TABLE artists_import (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255)
);