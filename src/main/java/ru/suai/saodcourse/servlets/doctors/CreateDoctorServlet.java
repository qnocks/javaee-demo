package ru.suai.saodcourse.servlets.doctors;

import ru.suai.saodcourse.models.Doctor;
import ru.suai.saodcourse.repositories.DoctorsRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors/create")
public class CreateDoctorServlet extends HttpServlet {

    DoctorsRepository doctorsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        doctorsRepository = (DoctorsRepository) req.getServletContext().getAttribute("doctorsRepos");
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/doctors/create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String specialty = req.getParameter("specialty");
        Integer officeNumber = Integer.parseInt(req.getParameter("officeNumber"));
        String schedule = req.getParameter("schedule");
        Doctor doctor = new Doctor(fullName, specialty, officeNumber, schedule);
        doctorsRepository.save(doctor);
        req.setAttribute("doctors", doctorsRepository.findAll());
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/doctors/list.jsp");
        dispatcher.forward(req, resp);
//      resp.sendRedirect(req.getContextPath() + "/doctors");
    }
}
