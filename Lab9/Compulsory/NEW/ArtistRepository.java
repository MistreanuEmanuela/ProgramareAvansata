package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class ArtistRepository {

    private static EntityManagerFactory entityManagerFactory;

    private ArtistRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
    }

    private static class SingletonHelper {
        private static final ArtistRepository INSTANCE = new ArtistRepository();
    }

    public static ArtistRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void create(Artist artist) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
    }

    public Artist findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Artist artist = em.find(Artist.class, id);
        em.close();
        if (artist == null) {
            throw new EntityNotFoundException("Cannot find artist with id: " + id);
        }
        return artist;
    }

    public List<Artist> findByName(String namePattern) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Artist> artists = em.createNamedQuery("Artist.findByName", Artist.class)
                .setParameter("namePattern", "%" + namePattern + "%")
                .getResultList();
        em.close();
        return artists;
    }

    public void close() {
        entityManagerFactory.close();
    }
}
