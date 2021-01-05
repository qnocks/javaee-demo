package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.repositories.PatientsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients/find")
public class FindPatientServlet extends HttpServlet {

    PatientsRepository patientsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.patientsRepository = (PatientsRepository) req.getServletContext().getAttribute("patientsRepos");
        req.getRequestDispatcher("/jsp/patients/find.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String registrationNumber = req.getParameter("registrationNumber");
        String fullName = req.getParameter("fullName");
        if (registrationNumber.isEmpty() && !fullName.isEmpty()) {
//           Patient patient = this.patientsRepository.findByRegistrationNumber();
//           req.getRequestDispatcher("/patients" + patient.getId()).forward(req, resp);
        }
        else if (!registrationNumber.isEmpty() && fullName.isEmpty()) {
//            Patient patient = this.patientsRepository.findByFullName();
//            req.getRequestDispatcher("/patients" + patient.getId()).forward(req, resp);
        }
    }
}
