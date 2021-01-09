package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Doctor;

import java.util.List;

public interface DoctorsRepository {

    List<Doctor> findAll();
    void save(Doctor doctor);
    boolean delete(Long id);
    Doctor findById(Long id);
    Doctor findByFullName(String fullName);
    List<Doctor> findBySpecialty(String specialty);
}
