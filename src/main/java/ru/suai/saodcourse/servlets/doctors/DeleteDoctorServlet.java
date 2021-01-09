package ru.suai.saodcourse.servlets.doctors;

import ru.suai.saodcourse.repositories.DoctorsRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctors/delete/*")
public class DeleteDoctorServlet extends HttpServlet {

    @Inject
    DoctorsRepository doctorsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        doctorsRepository.delete(getId(req));
        resp.sendRedirect("/doctors");
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        long id = Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
        return id;
    }
}
