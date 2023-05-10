package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class GenreRepository {

    private static EntityManagerFactory entityManagerFactory;

    private GenreRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
    }

    private static class SingletonHelper {
        private static final GenreRepository INSTANCE = new GenreRepository();
    }

    public static GenreRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void create(Genre genre) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
        em.close();
    }

    public Genre findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Genre genre = em.find(Genre.class, id);
        em.close();
        if (genre == null) {
            throw new EntityNotFoundException("Cannot find artist with id: " + id);
        }
        return genre;
    }

    public List<Genre> findByName(String namePattern) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Genre> genres = em.createNamedQuery("Artist.findByName", Genre.class)
                .setParameter("namePattern", "%" + namePattern + "%")
                .getResultList();
        em.close();
        return genres;
    }

    public void close() {
        entityManagerFactory.close();
    }
}
