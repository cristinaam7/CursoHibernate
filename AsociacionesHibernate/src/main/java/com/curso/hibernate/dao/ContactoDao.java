package com.curso.hibernate.dao;

import com.curso.hibernate.domain.Contacto;
import java.util.List;
import javax.persistence.Query;

public class ContactoDao extends GenericDao {
    public List<Contacto> listar() {
        String hql = "SELECT c FROM Contacto c";

        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public Contacto buscarContactoById(Contacto contacto) {
        em = getEntityManager();
        return em.find(Contacto.class, contacto.getIdContacto());
    }

    public void crear(Contacto contacto) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void actualizar(Contacto contacto) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Contacto contacto) {
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}
