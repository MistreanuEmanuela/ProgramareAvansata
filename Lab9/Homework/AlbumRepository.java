package org.example;
import javax.persistence.EntityManager;

public class AlbumRepository extends DataRepository<Album, Integer> {
    public AlbumRepository(EntityManager entityManager) {
        super(entityManager, Album.class);
    }
}

