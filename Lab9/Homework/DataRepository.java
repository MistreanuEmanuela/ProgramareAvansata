package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.sql.SQLException;
import javax.persistence.EntityManager;

public abstract class DataRepository <T, ID extends Serializable> {

        private  EntityManager entityManager;
        private Class<T> entityClass;

        public DataRepository(EntityManager entityManager, Class<T> entityClass) {
            this.entityManager = entityManager;
            this.entityClass = entityClass;
        }

        public void create(T entity) {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }

        public Optional<T> findById(ID id) {
            T entity = entityManager.find(entityClass, id);
            return Optional.ofNullable(entity);
        }

        public List<T> findByName(String namePattern) {
            Query query = entityManager.createNamedQuery(entityClass.getSimpleName() + ".findByName");
            query.setParameter("namePattern", "%" + namePattern + "%");
            return query.getResultList();
        }


    public void persist(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }
}

