package ru.suai.saodcourse.servlets.doctors;

import ru.suai.saodcourse.models.Doctor;
import ru.suai.saodcourse.models.Patient;
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
import java.util.LinkedList;
import java.util.List;

@WebServlet("/doctors/find")
public class FindDoctorServlet extends HttpServlet {

    DoctorsRepository doctorsRepository;

    ReferralsRepository referralsRepository;
    PatientsRepository patientsRepository;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doctorsRepository = (DoctorsRepository) req.getServletContext().getAttribute("doctorsRepos");
        this.patientsRepository = (PatientsRepository) req.getServletContext().getAttribute("patientsRepos");
        this.referralsRepository = (ReferralsRepository) req.getServletContext().getAttribute("referralsRepos");
        req.getRequestDispatcher("/jsp/doctors/find.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String specialty = req.getParameter("specialty");

        if (!fullName.isEmpty() && specialty.isEmpty()) {
            Doctor doctor = this.doctorsRepository.findByFullName(fullName);
            List<Referral> referrals = this.referralsRepository.findByDoctorFullName(fullName);

            List<Patient> boundedPatients = new LinkedList<>();

            for (var referral : referrals) {
                boundedPatients.add(patientsRepository.findByRegistrationNumber(referral.getPatientRegistrationNumber()));
            }
            req.setAttribute("doctor", doctor);
            req.setAttribute("boundedPatients", boundedPatients);
            req.getRequestDispatcher("/doctors").forward(req, resp);
        }
        else if (!specialty.isEmpty() && fullName.isEmpty()) {
            List<Doctor> doctors = this.doctorsRepository.findBySpecialty(specialty);
            req.setAttribute("doctors", doctors);
            req.getRequestDispatcher("/doctors").forward(req, resp);
        }
    }
}
