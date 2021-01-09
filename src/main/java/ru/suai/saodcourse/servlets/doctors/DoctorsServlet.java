package ru.suai.saodcourse.servlets.doctors;

import ru.suai.saodcourse.repositories.DoctorsRepository;
import ru.suai.saodcourse.repositories.DoctorsRepositoryAVLTreeImpl;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors")
public class DoctorsServlet extends HttpServlet {

    @Inject
    DoctorsRepository doctorsRepository;

//    This is no longer needed
//    @Override
//    public void init(ServletConfig config) {
//        config.getServletContext().setAttribute("doctorsRepos", this.doctorsRepository);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("doctors", doctorsRepository.findAll());
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/doctors/list.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/doctors/list.jsp").forward(req, resp);
    }
}
