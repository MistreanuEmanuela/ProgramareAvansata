package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Main {
    public static void testJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        Album album=new Album(1900,"Ani60");
        Genre genre=new Genre("Rock");
        em.persist(album);
        em.persist(artist);
        em.persist(genre);
        Artist a = (Artist)em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();
        System.out.println(a);
        a.setName("The Beatles");
        Album b = (Album)em.createQuery(
                        "select e from Album e where e.title='Ani60'")
                .getSingleResult();
        b.setArtist(a.getName());
        b.setTitle("Anii90");
        Genre g=(Genre)em.createQuery(
                        "select e from Genre e where e.name='Rock'")
                .getSingleResult();
        g.setName("Rockk");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    public static void main(String[] args) {
        testJPA();
    }
}