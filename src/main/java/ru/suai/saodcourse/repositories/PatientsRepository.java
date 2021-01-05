package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Doctor;
import ru.suai.saodcourse.models.Patient;

import java.util.List;

public interface PatientsRepository {
    List<Patient> findAll();
    void save(Patient patient);
    boolean delete(Long id);
    Patient findById(Long id);
    Patient findByRegistrationNumber(String registrationNumber);
}
