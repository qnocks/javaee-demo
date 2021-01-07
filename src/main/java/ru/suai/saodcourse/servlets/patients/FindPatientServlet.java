package ru.suai.saodcourse.servlets.patients;

import ru.suai.saodcourse.models.Patient;
import ru.suai.saodcourse.models.Referral;
import ru.suai.saodcourse.repositories.PatientsRepository;
import ru.suai.saodcourse.repositories.ReferralsRepository;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patients/find")
public class FindPatientServlet extends HttpServlet {

    PatientsRepository patientsRepository;

    ReferralsRepository referralsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.patientsRepository = (PatientsRepository) req.getServletContext().getAttribute("patientsRepos");
        this.referralsRepository = (ReferralsRepository) req.getServletContext().getAttribute("referralsRepos");
        req.getRequestDispatcher("/jsp/patients/find.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String registrationNumber = req.getParameter("registrationNumber");
        String fullName = req.getParameter("fullName");
        if (registrationNumber.isEmpty() && !fullName.isEmpty()) {
            List<Patient> patients = this.patientsRepository.findByFullName(fullName);
            req.setAttribute("patients", patients);
            req.getRequestDispatcher("/patients").forward(req, resp);
        }
        else if (!registrationNumber.isEmpty() && fullName.isEmpty()) {
            Patient foundPatient = this.patientsRepository.findByRegistrationNumber(registrationNumber);
            if (foundPatient == null) {
                resp.sendError(400);
            } else {
                req.setAttribute("patient", foundPatient);
                Referral referral = referralsRepository.findByPatientRegistrationNumber(foundPatient.getRegistrationNumber());
                if (referral != null) {
                    req.setAttribute("doctorFullName", referral.getDoctorFullName());
                }
                req.getRequestDispatcher("/patients").forward(req, resp);
            }
        }
    }
}
