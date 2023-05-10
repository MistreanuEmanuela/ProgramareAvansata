package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.util.List;

public class AlbumRepository {

    private static EntityManagerFactory entityManagerFactory;

    private AlbumRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
    }

    private static class SingletonHelper {
        private static final AlbumRepository INSTANCE = new AlbumRepository();
    }

    public static AlbumRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void create(Album album) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
    }

    public Album findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Album album = em.find(Album.class, id);
        em.close();
        if (album == null) {
            throw new EntityNotFoundException("Cannot find album with id: " + id);
        }
        return album;
    }

    public List<Album> findByName(String namePattern) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Album> albums = em.createNamedQuery("Album.findByName", Album.class)
                .setParameter("namePattern", "%" + namePattern + "%")
                .getResultList();
        em.close();
        return albums;
    }

    public void close() {
        entityManagerFactory.close();
    }
}
