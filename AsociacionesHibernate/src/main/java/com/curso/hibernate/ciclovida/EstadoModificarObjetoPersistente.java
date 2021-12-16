package com.curso.hibernate.ciclovida;

import com.curso.hibernate.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EstadoModificarObjetoPersistente {
      public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //definimos la variable
        Contacto contacto = null;

        //recuperamos el objeto
        //1. detached
        contacto = em.find(Contacto.class, 3);
        
        //modificamos el objeto
        contacto.setEmail("clara@mail.com");
        
        
        em.getTransaction().begin();

        //2. persistente
        //em.persist(contacto);
        em.merge(contacto);
        
        em.getTransaction().commit(); //Aqui queda persistido

        //3. detached
        System.out.println("contacto = " + contacto);
    }

}
