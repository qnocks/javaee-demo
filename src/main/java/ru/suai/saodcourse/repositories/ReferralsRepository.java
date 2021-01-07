package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Referral;

import java.util.List;

public interface ReferralsRepository {
    List<Referral> findAll();
    void save(Referral referral);
    boolean delete(Long id);
    Referral findById(Long id);
    Referral findByPatientRegistrationNumber(String patientRegistrationNumber);
    List<Referral> findByDoctorFullName(String doctorFullName);
}
