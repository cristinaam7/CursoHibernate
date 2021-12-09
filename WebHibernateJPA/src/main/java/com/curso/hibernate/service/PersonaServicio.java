package com.curso.hibernate.service;

import com.curso.hibernate.dao.PersonaDao;
import com.curso.hibernate.domain.Persona;
import java.util.List;

public class PersonaServicio {

    PersonaDao personaDao;

    public PersonaServicio() {
        personaDao = new PersonaDao();
    }

    public List<Persona> listarPersonas() {
        return personaDao.listar();
    }
}
