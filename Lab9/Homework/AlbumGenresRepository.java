package org.example;

import javax.persistence.EntityManager;

public class AlbumGenresRepository extends DataRepository<AlbumGenres, Integer> {
    public AlbumGenresRepository(EntityManager entityManager, Class<AlbumGenres> entityClass) {
        super(entityManager, entityClass);
    }
}
