package ru.suai.saodcourse.servlets.referrals;


import ru.suai.saodcourse.repositories.ReferralsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/referrals/delete/*")
public class DeleteReferralServlet extends HttpServlet {

    ReferralsRepository referralsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        referralsRepository = (ReferralsRepository) req.getServletContext().getAttribute("referralsRepos");
        referralsRepository.delete(getId(req));
        resp.sendRedirect("/referrals");
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        return Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
    }
}
