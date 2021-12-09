package com.curso.hibernate.web;

import com.curso.hibernate.domain.Persona;
import com.curso.hibernate.service.PersonaServicio;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        PersonaServicio personaServicio = new PersonaServicio();
        List<Persona> personas = personaServicio.listarPersonas();

        request.setAttribute("personas", personas);
        try {
            request.getRequestDispatcher("WEB-INF/listado.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
