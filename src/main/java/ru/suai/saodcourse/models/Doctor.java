package ru.suai.saodcourse.models;

public class Doctor {
    private String fullName;
    private String specialty;
    private Integer officeNumber;
    private String schedule;

    public Doctor(String fullName, String specialty, Integer officeNumber, String schedule) {
        this.fullName = fullName;
        this.specialty = specialty;
        this.officeNumber = officeNumber;
        this.schedule = schedule;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(Integer officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
