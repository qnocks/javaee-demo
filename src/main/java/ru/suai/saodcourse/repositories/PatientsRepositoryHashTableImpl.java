package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Patient;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PatientsRepositoryHashTableImpl implements PatientsRepository {

    private final Map<String, Patient> patients = new HashMap<>();

    {
        var patient = new Patient("55-882561", "Ivan Sidikov",
                LocalDate.parse("1992-02-02"), "Kazan", "Professor");
        var patient2 = new Patient("74-522575", "Andrew Petrov",
                LocalDate.parse("2001-12-19"), "Spb", "Student");
        var patient3 = new Patient("42-962312", "Maria Gladkova",
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

    @Override
    public boolean delete(Long id) {
        Patient patient = findById(id);
        if (patient == null) return false;
        patients.remove(patient.getRegistrationNumber(), patient);
        return true;
    }

    @Override
    public Patient findById(Long id) {
        for(Map.Entry<String, Patient> patientEntry : patients.entrySet()) {
            if (patientEntry.getValue().getId().equals(id)) {
                return patientEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Patient findByRegistrationNumber(String registrationNumber) {
        for(Map.Entry<String, Patient> patientEntry : patients.entrySet()) {
            if (patientEntry.getValue().getRegistrationNumber().equals(registrationNumber)) {
                return patientEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public List<Patient> findByFullName(String fullName) {
        List<Patient> findedPatients = new LinkedList<>();
        for(Map.Entry<String, Patient> patientEntry : patients.entrySet()) {
            if (patientEntry.getValue().getFullName().equals(fullName)) {
                findedPatients.add(patientEntry.getValue());
            }
        }
        return findedPatients;
    }
}
