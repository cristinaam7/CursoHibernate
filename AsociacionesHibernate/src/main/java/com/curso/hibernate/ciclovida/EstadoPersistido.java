package com.curso.hibernate.ciclovida;

import com.curso.hibernate.domain.Contacto;
import javax.persistence.*;

public class EstadoPersistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("11223344");
        
        //2.persistimos el objeto
        em.getTransaction().begin();
        
        em.persist(contacto);
        
        em.getTransaction().commit(); //Aqui es cuando realmente se guarda en bd
        
        //3. detached (separado)
        //A partir de aqui si hacemos cualquier cambio en el objeto no estara sincronzado
        System.out.println("contacto = " + contacto);
    }
    
}
