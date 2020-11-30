package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Doctor;

import java.util.List;
import java.util.TreeMap;
import java.util.function.DoublePredicate;

public interface DoctorsRepository {

    List<Doctor> findAll();
    void save(Doctor doctor);
}
