package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Patient;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PatientsRepositoryHashTableImpl implements PatientRepository {

    Map<String, Patient> patients = new HashMap<>();

    {
        var patient = new Patient("55-882561", "Marsel Sidikov",
                LocalDate.parse("1992-02-02"), "Kazan", "Professor");
        var patient2 = new Patient("74-522575", "Andrew Petrov",
                LocalDate.parse("2001-12-19"), "Spb", "Student");
        var patient3 = new Patient("42-962312", "Maria Toporisheva",
                LocalDate.parse("1992-02-02"), "Turkmen", "Schoolgirl");

        patients.put(patient.getRegistrationNumber(), patient);
        patients.put(patient2.getRegistrationNumber(), patient2);
        patients.put(patient3.getRegistrationNumber(), patient3);
    }

    @Override
    public List<Patient> findAll() {
        return new LinkedList<Patient>(patients.values());
    }

    @Override
    public void save(Patient patient) {
        patients.put(patient.getRegistrationNumber(), patient);
    }
}
