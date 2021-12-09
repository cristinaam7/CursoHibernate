package com.curso.hibernate.servicio;

import com.curso.hibernate.dao.AlumnoDao;
import com.curso.hibernate.domain.Alumno;
import java.util.List;

public class AlumnoService {

    private AlumnoDao alumnoDao;

    public AlumnoService() {
        alumnoDao = new AlumnoDao();
    }

    public List<Alumno> Listar() {
        return alumnoDao.listar();
    }

    public Alumno buscar(Alumno alumno) {
        return alumnoDao.buscarAlumnoById(alumno);
    }

    public void crear(Alumno alumno) {
        alumnoDao.crear(alumno);
    }

    public void actualizar(Alumno alumno) {
        alumnoDao.actualizar(alumno);
    }

    public void guardar(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            alumnoDao.crear(alumno);
        }
        else{
            alumnoDao.actualizar(alumno);
        }
    }

    public void eliminar(Alumno alumno){
        alumnoDao.eliminar(alumno);
    }
}
