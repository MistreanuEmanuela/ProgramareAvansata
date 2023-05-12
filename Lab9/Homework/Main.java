package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void testJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManagerFactory emfs= EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager em=emfs.createEntityManager();
        Artist artist = new Artist("Beatles90");
        Artist artist1=new Artist("Nume505");
        Album album=new Album(1900,"Title56");
        Genre genre=new Genre("Rock56");
        ArtistRepository art=new ArtistRepository(em);
        AlbumRepository alb=new AlbumRepository(em);
        GenreRepository gen=new GenreRepository(em);
        art.create(artist);
        art.persist(artist);
        art.create(artist1);
        art.persist(artist1);
        Artist a = (Artist)em.createQuery(
                        "select e from Artist e where e.name='Beatles90'")
                .getSingleResult();
        System.out.println(a);
        alb.create(album);
        gen.create(genre);
        a.setName("The Beatles");
        Album b = (Album)em.createQuery(
                       "select e from Album e where e.title='Title56'")
                .getSingleResult();
        System.out.println(b);
        b.setArtist(a.getName());
        b.setTitle("Anii90");
        Genre g=(Genre)em.createQuery(
                       "select e from Genre e where e.name='Rock56'")
               .getSingleResult();
        g.setName("Rockk");
        for (int i=0; i<=10000; i++)
        {
            Artist arti=new Artist("Nume"+i);
            art.create(arti);
            art.persist(arti);
        }
        List<Artist> artis = art.findByName("Beatles");
        Optional<Artist> artist2=art.findById(30040);
        System.out.println(artis);
        System.out.println(artist2);
        em.close();
        emf.close();
    }
    public static void main(String[] args) {
        testJPA();
    }
}