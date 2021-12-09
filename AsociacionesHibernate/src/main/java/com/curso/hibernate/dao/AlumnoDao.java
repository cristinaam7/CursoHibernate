package com.curso.hibernate.dao;

import com.curso.hibernate.domain.Alumno;
import java.util.List;
import javax.persistence.Query;

public class AlumnoDao extends GenericDao {

    public List<Alumno> listar() {
        String hql = "SELECT a FROM Alumno a";

        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public Alumno buscarAlumnoById(Alumno alumno) {
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }

    public void crear(Alumno alumno) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void actualizar(Alumno alumno) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Alumno alumno) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}
