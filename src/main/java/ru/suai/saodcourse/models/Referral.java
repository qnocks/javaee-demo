package ru.suai.saodcourse.models;
/*

Данные о выдаче или возврате направлений к врачу должны
содержать:

    - Регистрационный No – строка, формат которой соответствует
аналогичной строке в данных о больных;
    - ФИО врача – строка, формат которой соответствует аналогичной
строке в данных о врачах;
    - Дата направления – строка;
    - Время направления – строка.

*/

import java.time.LocalDate;

public class Referral {

    private String patientRegistrationNumber;
    private String doctorFullName;
    private LocalDate referralDate;

    public Referral(String patientRegistrationNumber, String doctorFullName, LocalDate referralDate) {
        this.patientRegistrationNumber = patientRegistrationNumber;
        this.doctorFullName = doctorFullName;
        this.referralDate = referralDate;
    }

    public void setPatientRegistrationNumber(String patientRegistrationNumber) {
        this.patientRegistrationNumber = patientRegistrationNumber;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public void setReferralDate(LocalDate referralDate) {
        this.referralDate = referralDate;
    }

    public String getPatientRegistrationNumber() {
        return patientRegistrationNumber;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public LocalDate getReferralDate() {
        return referralDate;
    }
}
