package org.example;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
public class EntityManagerFactoryS {

        private static EntityManagerFactory entityManagerFactory;

        private void EntityManagerFactoryS() {}

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");

        }
        return entityManagerFactory;
    }

        public static synchronized void closeEntityManagerFactory() {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
                entityManagerFactory = null;
            }
        }
    }

