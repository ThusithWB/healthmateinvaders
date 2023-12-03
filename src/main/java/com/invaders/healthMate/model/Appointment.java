package com.invaders.healthMate.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

// Appointment.java
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name")
    private String patientName;
    private String phoneNumber;
    private String address;
    private String email;
    private String location;
    private String doctorName;
    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

    public Appointment() {
        // Default constructor
    }

    // Getters and setters
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }
}
