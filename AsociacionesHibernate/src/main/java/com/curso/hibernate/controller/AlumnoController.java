package com.curso.hibernate.controller;

import com.curso.hibernate.domain.Alumno;
import com.curso.hibernate.servicio.AlumnoService;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AlumnoController")
public class AlumnoController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        AlumnoService alumnoService = new AlumnoService();

        List<Alumno> alumnos = alumnoService.Listar();
        request.setAttribute("alumnos", alumnos);

        try {
            //Redireccionamos a la pagina de listar alumno y le pasamos la peticion y la respuesta
            request.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
    }

}
