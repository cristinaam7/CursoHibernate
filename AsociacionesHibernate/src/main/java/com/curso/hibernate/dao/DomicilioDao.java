package com.curso.hibernate.dao;

import com.curso.hibernate.domain.Domicilio;
import java.util.List;
import javax.persistence.Query;

public class DomicilioDao extends GenericDao {

    public List<Domicilio> listar() {
        String hql = "SELECT d FROM Domicilio d";

        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public Domicilio buscarAlumnoById(Domicilio domicilio) {
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }

    public void crear(Domicilio domicilio) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void actualizar(Domicilio domicilio) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Domicilio domicilio) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}
