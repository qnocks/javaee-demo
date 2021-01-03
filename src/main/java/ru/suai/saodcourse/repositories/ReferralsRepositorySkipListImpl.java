package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Patient;
import ru.suai.saodcourse.models.Referral;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReferralsRepositorySkipListImpl implements ReferralsRepository {

    List<Referral> referrals = new ArrayList<>();

    {
        referrals.add(new Referral("55-882561", "Vladislav", LocalDate.parse("2020-12-31")));
        referrals.add(new Referral("74-522575", "Alena", LocalDate.parse("2021-01-02")));
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
}
