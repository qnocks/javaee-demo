package ru.suai.saodcourse.models;

import java.time.LocalDate;

public class Patient {

    private static long autoIncrement= 0L;

    private Long id;
    private String registrationNumber;
    private String fullName;
    private LocalDate birthDate;
    private String address;
    private String job;

    public Patient() {}

    public Patient(String registrationNumber, String fullName, LocalDate birthDate, String address, String job) {
        this.id = ++autoIncrement;
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.job = job;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
