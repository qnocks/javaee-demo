package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Referral;

import java.util.List;

public interface ReferralsRepository {
    List<Referral> findAll();
    void save(Referral referral);
 }
