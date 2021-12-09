package com.curso.hibernate.ciclovida;

import com.curso.hibernate.domain.Contacto;
import javax.persistence.*;

public class EstadoEliminarObjeto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //definimos la variable
        Contacto contacto = null;

        //recuperamos el objeto
        //1. transitivo
        contacto = em.find(Contacto.class, 3);

        em.getTransaction().begin();

        //3. remove
        em.remove(em.merge(contacto));

        em.getTransaction().commit();

        //3. transitivo
        System.out.println("contacto = " + contacto);
    }

}
