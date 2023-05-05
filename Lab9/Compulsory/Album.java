package org.example;

import javax.persistence.*;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Album e where e.artist = ?1"),
        @NamedQuery(name = "Album.findByName",
                query = "select e from Album e where e.title = ?1"),
        @NamedQuery(name = "Album.findById",
                query = "select e from Album e where e.id = ?1"),
        @NamedQuery(name = "Album.create",
                query = "insert into Album (title) values ?1"),
        })
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "year")
    private int year;

    @Column(name = "gender")
    private String gender;

}