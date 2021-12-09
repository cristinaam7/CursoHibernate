package com.curso.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {

    private final static String UNIT_PERSISTENCE = "my_persistence_unit";
    private EntityManagerFactory emf;
    protected EntityManager em;

    public GenericDao() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory(UNIT_PERSISTENCE);
    }

    public EntityManager getEntityManager() {
        if(em == null)
            em = emf.createEntityManager();
        return em;
    }

}
