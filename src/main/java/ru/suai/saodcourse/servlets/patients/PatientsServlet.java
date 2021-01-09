package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.repositories.PatientsRepository;
import ru.suai.saodcourse.repositories.PatientsRepositoryHashTableImpl;

import javax.inject.Inject;
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

    @Inject
    PatientsRepository patientsRepository;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        config.getServletContext().setAttribute("patientsRepos", this.patientsRepository);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("patients", this.patientsRepository.findAll());
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/patients/list.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/patients/list.jsp").forward(req, resp);
    }
}
