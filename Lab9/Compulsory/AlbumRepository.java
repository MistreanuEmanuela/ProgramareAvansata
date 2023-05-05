package org.example;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository {
    private EntityManager em;

    public List<Album> findByArtist(Artist artist) {
        return em.createNamedQuery("Album.findByArtist")
                .setParameter("artist", artist)
                .getResultList();
    }
    public List<Album> findById(int id) {
        return em.createNamedQuery("Album.findById")
                .setParameter("id", id)
                .getResultList();
    }
    public List<Album> findByName(String name) {
        return em.createNamedQuery("Album.findByName")
                .setParameter("title", name)
                .getResultList();

    }
}