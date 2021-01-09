package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.models.Patient;
import ru.suai.saodcourse.repositories.PatientsRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/patients/update/*")
public class UpdatePatientServlet extends HttpServlet {

    @Inject
    PatientsRepository patientsRepository;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("patient", patientsRepository.findById(getId(req)));
        req.getRequestDispatcher("/jsp/patients/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String registrationNumber = req.getParameter("registrationNumber");
        String fullName = req.getParameter("fullName");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        String address = req.getParameter("address");
        String job = req.getParameter("job");
        Patient patient = new Patient(registrationNumber, fullName, birthDate, address, job);
        this.patientsRepository.save(patient);
        resp.sendRedirect("/patients");
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        return Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
    }
}
