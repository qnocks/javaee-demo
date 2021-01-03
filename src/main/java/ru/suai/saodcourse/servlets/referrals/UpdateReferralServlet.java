package ru.suai.saodcourse.servlets.referrals;

import ru.suai.saodcourse.models.Referral;
import ru.suai.saodcourse.repositories.ReferralsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/referrals/update/*")
public class UpdateReferralServlet extends HttpServlet {

    ReferralsRepository referralsRepository;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.referralsRepository = (ReferralsRepository) req.getServletContext().getAttribute("referralsRepos");
        resp.setContentType("text/html");
        long id = getId(req);
        Referral referral = this.referralsRepository.findById(id);
        req.setAttribute("id", referral.getId());
        req.setAttribute("patientRegistrationNumber", referral.getPatientRegistrationNumber());
        req.setAttribute("doctorFullName", referral.getDoctorFullName());
        req.setAttribute("referralDate", referral.getReferralDate());
        req.getRequestDispatcher("/jsp/referrals/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientRegistrationNumber = req.getParameter("patientRegistrationNumber");
        String doctorFullName = req.getParameter("doctorFullName");
        LocalDate referralDate = LocalDate.parse(req.getParameter("referralDate"));
        Referral referral = new Referral(patientRegistrationNumber, doctorFullName, referralDate);
        this.referralsRepository.save(referral);
        resp.sendRedirect("/referrals");
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        long id = Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
        return id;
    }
}
