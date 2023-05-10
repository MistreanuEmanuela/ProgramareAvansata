package org.example;

import javax.persistence.EntityManager;


public class GenreRepository extends DataRepository<Genre, Integer> {
    public GenreRepository(EntityManager entityManager) {
        super(entityManager, Genre.class);
    }

}