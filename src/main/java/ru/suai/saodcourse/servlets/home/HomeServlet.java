package ru.suai.saodcourse.servlets.home;

import ru.suai.saodcourse.repositories.PatientRepository;
import ru.suai.saodcourse.repositories.PatientsRepositoryHashTableImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private PatientRepository patientRepository;

    @Override
    public void init() throws ServletException {
        this.patientRepository = new PatientsRepositoryHashTableImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("patients", patientRepository.findAll());

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/home/home.jsp");
        dispatcher.forward(req, resp);
    }
}
