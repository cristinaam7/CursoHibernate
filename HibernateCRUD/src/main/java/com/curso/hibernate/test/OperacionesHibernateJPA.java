package com.curso.hibernate.test;

import com.curso.hibernate.dao.PersonaDao;
import com.curso.hibernate.domain.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OperacionesHibernateJPA {
    
    public static void main(String[] args) {
        
        PersonaDao personaDao = new PersonaDao();
        
        Persona persona = new Persona();
        persona.setIdPersona(3);

        persona = personaDao.buscarPersonaPorId(persona);

        //persona.setTelefono("999999999");
        //personaDao.actualizar(persona);

        personaDao.eliminar(persona);
        
        personaDao.listar();
        
    }
}
