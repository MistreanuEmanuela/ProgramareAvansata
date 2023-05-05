package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from artists e order by e.name"),
        @NamedQuery(name = "Artist.findById",
                query = "select e from artist e where e.id = ?1"),
        @NamedQuery(name = "Artist.findByName",
                query = "select e from artist e where e.name = ?1"),
        @NamedQuery(name = "Artist.create",
                query = "insert into e (name) values ?1"),
})
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}