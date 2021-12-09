package com.curso.hibernate.dao;

import com.curso.hibernate.domain.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
public class PersonaDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDao() {
        emf = Persistence.createEntityManagerFactory("HibernateUP");
        em = emf.createEntityManager();
    }

    public List<Persona> listar() {

        //hql: Hibernate Query Language
        //Recuperamos objetos completos
        //Usamos las clases no las tablas
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);
        return  query.getResultList();
    }

    public Persona buscarPersonaPorId(Persona persona) {

        return em.find(Persona.class, persona.getIdPersona());
    }

    public void insertar(Persona persona) {

        //Como no desplegamos en un servidor de aplicaciones empresarial
        //Nos tenemos que hacer cargo nosotros de gestionar la transaccion
        // Y cerrar las clases necesarias
        try {
            em.getTransaction().begin();
            //Esto directamente mete el objeto persona en la tabla persona
            // Y genera el id automáticamente
            em.persist(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void actualizar(Persona persona) {

        //Como no desplegamos en un servidor de aplicaciones empresarial
        //Nos tenemos que hacer cargo nosotros de gestionar la transaccion
        // Y cerrar las clases necesarias
        try {
            em.getTransaction().begin();
            //Sincroniza la clase con la base de datos
            //En este caso busca por id y actualiza los campos necesarios
            em.merge(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Persona persona) {
        try {
            em.getTransaction().begin();
            // Primero hay que sincronizar con la bd
            // Y luego ya podemos borrar
            em.remove(em.merge(persona));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}