package ru.suai.saodcourse.servlets.referrals;

import ru.suai.saodcourse.models.Referral;
import ru.suai.saodcourse.repositories.DoctorsRepository;
import ru.suai.saodcourse.repositories.PatientsRepository;
import ru.suai.saodcourse.repositories.ReferralsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/referrals/create")
public class CreateReferralServlet extends HttpServlet {

    ReferralsRepository referralsRepository;

    PatientsRepository patientsRepository;
    DoctorsRepository doctorsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.referralsRepository = (ReferralsRepository) req.getServletContext().getAttribute("referralsRepos");
        this.patientsRepository = (PatientsRepository) req.getServletContext().getAttribute("patientsRepos");
        this.doctorsRepository = (DoctorsRepository) req.getServletContext().getAttribute("doctorsRepos");
        req.getServletContext().getRequestDispatcher("/jsp/referrals/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientRegistrationNumber = req.getParameter("patientRegistrationNumber");
        String doctorFullName = req.getParameter("doctorFullName");
        LocalDate referralDate = LocalDate.parse(req.getParameter("referralDate"));

        if (patientsRepository.findByRegistrationNumber(patientRegistrationNumber) != null
                && doctorsRepository.findByFullName(doctorFullName) != null) {
            Referral referral = new Referral(patientRegistrationNumber, doctorFullName, referralDate);
            this.referralsRepository.save(referral);
            resp.sendRedirect("/referrals");
        }
        else {
            resp.sendError(400);
        }
    }
}
