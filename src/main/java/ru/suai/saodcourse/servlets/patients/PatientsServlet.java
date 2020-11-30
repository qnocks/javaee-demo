package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.repositories.PatientRepository;
import ru.suai.saodcourse.repositories.PatientsRepositoryHashTableImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients")
public class PatientsServlet extends HttpServlet {

    PatientRepository patientRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.patientRepository = new PatientsRepositoryHashTableImpl();
        config.getServletContext().setAttribute("repos", patientRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("patients", patientRepository.findAll());
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/patients/list.jsp");
        dispatcher.forward(req, resp);
    }
}
