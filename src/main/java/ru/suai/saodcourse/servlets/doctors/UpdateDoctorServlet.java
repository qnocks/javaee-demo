package ru.suai.saodcourse.servlets.doctors;

import ru.suai.saodcourse.models.Doctor;
import ru.suai.saodcourse.repositories.DoctorsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors/update/*")
public class UpdateDoctorServlet extends HttpServlet {

    DoctorsRepository doctorsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doctorsRepository = (DoctorsRepository) req.getServletContext().getAttribute("doctorsRepos");
        resp.setContentType("text/html");
        req.setAttribute("doctor", doctorsRepository.findById(getId(req)));
        req.getRequestDispatcher("/jsp/doctors/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullName = req.getParameter("fullName");
        String specialty = req.getParameter("specialty");
        Integer officeNumber = Integer.parseInt(req.getParameter("officeNumber"));
        String schedule = req.getParameter("schedule");
        Doctor doctor = new Doctor(fullName, specialty, officeNumber, schedule);
        this.doctorsRepository.save(doctor);
        resp.sendRedirect("/doctors");
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        return Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
    }
}
