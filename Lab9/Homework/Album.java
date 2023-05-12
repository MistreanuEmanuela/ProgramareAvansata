package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
        @NamedQuery(name = "Album.findByName", query = "SELECT a FROM Album a WHERE a.title LIKE :namePattern")
})
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @ElementCollection
    @Column(name = "genre_ids", columnDefinition = "integer[]")
    private List<Integer> genreIds;

    public Album(Integer releaseYear, String title) {
        this.releaseYear = releaseYear;
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genreIds=" + genreIds +
                '}';
    }
}

