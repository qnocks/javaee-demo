package ru.suai.saodcourse.servlets.referrals;

import ru.suai.saodcourse.repositories.ReferralsRepository;
import ru.suai.saodcourse.repositories.ReferralsRepositorySkipListImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/referrals")
public class ReferralServlet extends HttpServlet {

    ReferralsRepository referralsRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.referralsRepository = new ReferralsRepositorySkipListImpl();
        config.getServletContext().setAttribute("referralsRepos", this.referralsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("referrals", this.referralsRepository.findAll());
        req.getServletContext().getRequestDispatcher("/jsp/referrals/list.jsp").forward(req, resp);
    }
}
