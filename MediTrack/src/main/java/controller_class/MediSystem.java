package controller_class;

import interfaces.Schedulable;
import sub_classes.Appointment;
import sub_classes.Doctor;
import sub_classes.Patient;

import javax.print.Doc;

public class MediSystem {
    private Doctor[] doctors;
    private Patient[] patients;
    private Appointment[] appointments;
    private int doctorCount, appointmentCount,patientCount;

    public void addDoctor(Doctor doctor) {
        if(doctor == null) {
            System.out.println("Given doctor is null!");
            return;
        }
        Doctor[] temp = new Doctor[++doctorCount];
        for (int i = 0; i < doctorCount-1; i++) {
            temp[i] = doctors[i];
        }
        temp[doctorCount-1] = doctor;
        doctors = temp;
    }

    public void addPatient(Patient patient) {
        if(patient == null) {
            System.out.println("Given patient is null!");
        }
        Patient[] temp = new Patient[++patientCount];
        for (int i = 0; i < patientCount-1; i++) {
            temp[i] = patients[i];
        }
        temp[patientCount-1] = patient;
        patients = temp;
    }

    public void scheduleAppointment(Appointment appointment) {
        if(appointment == null) {
            System.out.println("Given appointment is null!");
        }
        Appointment[] temp = new Appointment[++appointmentCount];
        for(int i = 0; i < appointmentCount-1; i++) {
            temp[i] = appointments[i];
        }
        temp[appointmentCount-1] = appointment;
        appointments = temp;
    }

    public void listAllAppointments() {
        if(appointments == null) {
            System.out.println("There is no appointments!");
            return;
        }
        for (int i = 0; i < appointmentCount-1; i++) {
            System.out.println(appointments[i]);
        }

    }

    public void listAllDoctors() {
        if(doctors == null) {
            System.out.println("There is no doctors!");
            return;
        }
        for (int i = 0; i < doctorCount-1; i++) {
            System.out.println(doctors[i]);
        }
    }

    public void listAllPatients() {
        if(patients == null) {
            System.out.println("There is no patients!");
            return;
        }
        for (int i = 0; i < patientCount-1; i++) {
            System.out.println(patients[i]);
        }
    }


}
