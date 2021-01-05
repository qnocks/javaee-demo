package ru.suai.saodcourse.repositories;

import ru.suai.saodcourse.models.Doctor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    @Override
    public boolean delete(Long id) {
        Doctor doctor = findById(id);
        if (doctor == null) return false;
        doctors.remove(doctor.getFullName(), doctor);
        return true;
    }

    @Override
    public Doctor findById(Long id) {
        for(Map.Entry<String, Doctor> doctorEntry : doctors.entrySet()) {
            if (doctorEntry.getValue().getId().equals(id)) {
                return doctorEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Doctor findByFullName(String fullName) {
        for(Map.Entry<String, Doctor> doctorEntry : doctors.entrySet()) {
            if (doctorEntry.getValue().getFullName().equals(fullName)) {
                return doctorEntry.getValue();
            }
        }
        return null;
    }

}
