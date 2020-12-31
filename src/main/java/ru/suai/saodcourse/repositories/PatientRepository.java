package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> findAll();
    void save(Patient patient);

}
