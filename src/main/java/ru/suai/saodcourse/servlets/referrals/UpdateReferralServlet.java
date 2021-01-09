package ru.suai.saodcourse.servlets.referrals;

import ru.suai.saodcourse.models.Referral;
import ru.suai.saodcourse.repositories.DoctorsRepository;
import ru.suai.saodcourse.repositories.PatientsRepository;
import ru.suai.saodcourse.repositories.ReferralsRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/referrals/update/*")
public class UpdateReferralServlet extends HttpServlet {

    @Inject
    ReferralsRepository referralsRepository;
    @Inject
    PatientsRepository patientsRepository;
    @Inject
    DoctorsRepository doctorsRepository;

    Referral referralToUpdate;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        referralToUpdate = this.referralsRepository.findById(getId(req));
        req.setAttribute("referral", referralToUpdate);
        req.getRequestDispatcher("/jsp/referrals/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String patientRegistrationNumber = req.getParameter("patientRegistrationNumber");
        String doctorFullName = req.getParameter("doctorFullName");
        LocalDate referralDate = LocalDate.parse(req.getParameter("referralDate"));

        if (patientsRepository.findByRegistrationNumber(patientRegistrationNumber) != null
                && doctorsRepository.findByFullName(doctorFullName) != null) {

            referralToUpdate.setPatientRegistrationNumber(patientRegistrationNumber);
            referralToUpdate.setDoctorFullName(doctorFullName);
            referralToUpdate.setReferralDate(referralDate);

            resp.sendRedirect("/referrals");
        }
        else {
            resp.sendError(400);
        }
    }

    private long getId(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        return Long.parseLong(url.substring(url.lastIndexOf('/') + 1));
    }
}
