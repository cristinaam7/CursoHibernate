package com.curso.hibernate.dao;

import com.curso.hibernate.domain.Asignacion;
import java.util.List;
import javax.persistence.Query;

public class AsignacionDao extends GenericDao {

    public List<Asignacion> listar() {
        String hql = "SELECT a FROM Asignacion a";

        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public Asignacion buscarAsignacionById(Asignacion asignacion) {
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }

    public void crear(Asignacion asignacion) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void actualizar(Asignacion asignacion) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Asignacion asignacion) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}
