package com.curso.hibernate.test;

import com.curso.hibernate.dao.AlumnoDao;
import com.curso.hibernate.dao.AsignacionDao;
import com.curso.hibernate.dao.ContactoDao;
import com.curso.hibernate.dao.CursoDao;
import com.curso.hibernate.dao.DomicilioDao;
import com.curso.hibernate.domain.Alumno;
import com.curso.hibernate.domain.Contacto;
import com.curso.hibernate.domain.Domicilio;
import java.util.List;

public class Test {
    
    public static void main(String[] args) {
        
        //Persistencia en cascada
        //Al pasarle el contacto y domicilio al alumno
        //Ya los crea en la BD

        //Sino indicaramos en cascada
        // Habria que crear contacto y guardarlo
        // Crear domicilio y guardarlo
        // Crear alumno y pasarle conctacto y domicilio ya creados
        Contacto contacto = new Contacto();
        contacto.setEmail("manoli@manoli.es");
        contacto.setTelefono("666777888");
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle Rave");
        domicilio.setNoCalle("27");
        domicilio.setPais("España");

        Alumno alumno = new Alumno();
        alumno.setNombre("Manuela");
        alumno.setApellido("Molina");
        alumno.setContacto(contacto);
        alumno.setDomicilio(domicilio);

        AlumnoDao alumnoDao = new AlumnoDao();
        alumnoDao.crear(alumno);


        System.out.println("Alumnos:");
        imprimir(alumnoDao.listar());
        
        DomicilioDao domicilioDao = new DomicilioDao();
        System.out.println("Domicilios:");
        imprimir(domicilioDao.listar());
        
        ContactoDao contactoDao = new ContactoDao();
        System.out.println("Contacto:");
        imprimir(contactoDao.listar());
        
        System.out.println("Cursos:");
        CursoDao cursoDao = new CursoDao();
        imprimir(cursoDao.listar());
        
        System.out.println("Asignaciones:");
        AsignacionDao asignacionDao = new AsignacionDao();
        imprimir(asignacionDao.listar());

        
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("valor = " + o);
        }
    }
    
}
