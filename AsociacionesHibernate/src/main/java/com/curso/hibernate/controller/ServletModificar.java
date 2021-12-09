package com.curso.hibernate.controller;

import com.curso.hibernate.domain.Alumno;
import com.curso.hibernate.domain.Contacto;
import com.curso.hibernate.domain.Domicilio;
import com.curso.hibernate.servicio.AlumnoService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idAlumno = Integer.valueOf(request.getParameter("idAlumno"));

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        AlumnoService alumnoService = new AlumnoService();
        alumno = alumnoService.buscar(alumno);

        //request.setAttribute("alumno", alumno);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AlumnoService servicioAlumno = new AlumnoService();

        HttpSession httpSession = request.getSession();
        Alumno alumno = (Alumno) httpSession.getAttribute("alumno");

        String modificar = request.getParameter("Modificar");

        if (modificar != null) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardar(alumno);
        } 
        else {
            servicioAlumno.eliminar(alumno);
        }

        httpSession.removeAttribute("alumno");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
