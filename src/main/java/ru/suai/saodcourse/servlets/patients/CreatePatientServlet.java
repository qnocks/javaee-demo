package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.models.Patient;
import ru.suai.saodcourse.repositories.PatientsRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/patients/create")
public class CreatePatientServlet extends HttpServlet {

    @Inject
    PatientsRepository patientsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/patients/create.jsp");
        req.getRequestDispatcher("/doctors/create");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String registrationNumber = req.getParameter("registrationNumber");
        String fullName = req.getParameter("fullName");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        String address = req.getParameter("address");
        String job = req.getParameter("job");
        Patient patient = new Patient(registrationNumber,fullName, birthDate, address, job);
        patientsRepository.save(patient);
        req.setAttribute("patients", patientsRepository.findAll());
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/patients/list.jsp");
        dispatcher.forward(req, resp);
    }
}
