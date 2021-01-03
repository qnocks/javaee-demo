package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.repositories.PatientsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients/delete/*")
public class DeletePatientServlet extends HttpServlet {

    PatientsRepository patientsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        patientsRepository = (PatientsRepository) req.getServletContext().getAttribute("patientsRepos");
        patientsRepository.delete(getId(req));
        resp.sendRedirect("/patients");
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        long id = Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
        return id;
    }
}
