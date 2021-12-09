package com.curso.hibernate.ciclovida;

import com.curso.hibernate.domain.Contacto;
import javax.persistence.*;

public class EstadoRecuperarObjectoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //NO necesitamos transaccion para recuperar un objeto

        //definimos la variable
        Contacto contacto = null;

        //recuperamos el objeto
        contacto = em.find(Contacto.class, 3);

        //detached
        System.out.println("contacto = " + contacto);
    }

}
