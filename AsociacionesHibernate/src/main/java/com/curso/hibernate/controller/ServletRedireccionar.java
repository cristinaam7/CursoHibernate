package com.curso.hibernate.controller;

import com.curso.hibernate.domain.Alumno;
import com.curso.hibernate.servicio.AlumnoService;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletRedireccionar")
public class ServletRedireccionar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/WEB-INF/agregarAlumno.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
