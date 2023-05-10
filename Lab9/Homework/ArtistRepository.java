package org.example;
import javax.persistence.EntityManager;


public class ArtistRepository extends DataRepository<Artist, Integer> {
        public ArtistRepository(EntityManager entityManager) {
            super(entityManager, Artist.class);
        }
    }

