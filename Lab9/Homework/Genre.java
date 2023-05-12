package org.example;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = "select e from Genre e order by e.name"),
        @NamedQuery(name = "Genre.findByName", query = "SELECT a FROM Genre a WHERE a.name LIKE :namePattern")
})
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Genre( String name) {

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

    public Genre() {
    }
}