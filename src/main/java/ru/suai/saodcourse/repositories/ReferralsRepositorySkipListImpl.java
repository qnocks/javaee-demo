package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Patient;
import ru.suai.saodcourse.models.Referral;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class ReferralsRepositorySkipListImpl implements ReferralsRepository {

    private final List<Referral> referrals = new ArrayList<>();

    {
        Referral referral = new Referral("55-882561", "Vladislav", LocalDate.parse("2020-12-31"));
        Referral referral2 = new Referral("74-522575", "Alena", LocalDate.parse("2021-01-02"));

        referrals.add(referral);
        referrals.add(referral2);
    }


    @Override
    public List<Referral> findAll() {
        return referrals;
    }

    @Override
    public void save(Referral referral) {
        referrals.add(referral);
    }

    @Override
    public boolean delete(Long id) {
        Referral referral = findById(id);
        if (referral == null) return false;
        referrals.remove(referral);
        return true;
    }

    @Override
    public Referral findById(Long id) {
        for(var referral : referrals) {
            if (referral.getId().equals(id)) {
                return referral;
            }
        }
        return null;
    }

    @Override
    public Referral findByPatientRegistrationNumber(String patientRegistrationNumber) {
        for(var referral : referrals) {
            if (referral.getPatientRegistrationNumber().equals(patientRegistrationNumber)) {
                return referral;
            }
        }
        return null;
    }

    @Override
    public List<Referral> findByDoctorFullName(String doctorFullName) {
        List<Referral> referralsToReturn = new LinkedList<>();
        for(var referral : referrals) {
            if (referral.getDoctorFullName().equals(doctorFullName)) {
                referralsToReturn.add(referral);
            }
        }
        return referrals;
    }
}

