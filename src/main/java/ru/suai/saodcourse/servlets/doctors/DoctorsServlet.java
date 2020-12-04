package ru.suai.saodcourse.servlets.doctors;

import ru.suai.saodcourse.repositories.DoctorsRepository;
import ru.suai.saodcourse.repositories.DoctorsRepositoryAVLTreeImpl;

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

    DoctorsRepository doctorsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.doctorsRepository = new DoctorsRepositoryAVLTreeImpl();
        config.getServletContext().setAttribute("doctorsRepos", this.doctorsRepository);
    }

//    @Override
//    public void init() throws ServletException {
//        this.doctorsRepository = new DoctorsRepositoryAVLTreeImpl();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("doctors", doctorsRepository.findAll());
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/doctors/list.jsp");
        dispatcher.forward(req, resp);
    }
}
