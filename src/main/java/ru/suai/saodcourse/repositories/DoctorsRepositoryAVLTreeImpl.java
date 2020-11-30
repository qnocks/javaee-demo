package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Doctor;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class DoctorsRepositoryAVLTreeImpl implements DoctorsRepository {

    TreeMap<String, Doctor> doctors = new TreeMap<>();

    {
        Doctor doctor = new Doctor("Vladislav", "Terapevt", 5, "9:00 - 14:00");
        Doctor doctor2 = new Doctor("Alena", "Xirurg", 1, "10:00 - 14:00");
        Doctor doctor3 = new Doctor("Kirill", "Lor", 10, "10:00 - 19:00");

        doctors.put(doctor.getFullName(), doctor);
        doctors.put(doctor2.getFullName(), doctor2);
        doctors.put(doctor3.getFullName(), doctor3);
    }

    @Override
    public List<Doctor> findAll() {
        return new LinkedList<>(doctors.values());
    }

    @Override
    public void save(Doctor doctor) {
        doctors.put(doctor.getFullName(), doctor);
    }
}
