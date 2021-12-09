package com.curso.hibernate.dao;

import com.curso.hibernate.domain.Curso;
import java.util.List;
import javax.persistence.Query;

public class CursoDao extends GenericDao {
    public List<Curso> listar() {
        String hql = "SELECT c FROM Curso c";

        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public Curso buscarCursoById(Curso curso) {
        em = getEntityManager();
        return em.find(Curso.class, curso.getIdCurso());
    }

    public void crear(Curso curso) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void actualizar(Curso curso) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Curso curso) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}
