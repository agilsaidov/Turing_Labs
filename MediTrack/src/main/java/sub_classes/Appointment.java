package sub_classes;

import java.util.Objects;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private String status;

    public Appointment(int id, Patient patient, Doctor doctor, String date, String time, String status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctorName() {
        return doctor.getName();
    }

    public String getPatientName() {
        return patient.getName();
    }

    public void printAppointmentInfo() {
        System.out.println("Appointment Details: "+
                          "\nDoctor: " + doctor
                        + "\nPatient: " + patient
                        + "\nDate: " + date
                        + "\nTime: " + time
                        + "\nStatus: " + status);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(patient, that.patient) && Objects.equals(doctor, that.doctor) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, date, time, status);
    }

    @Override
    public String toString() {
        return "Appointment " +
                "| patient=" + patient +
                "| doctor=" + doctor +
                "| date='" + date + '\'' +
                "| time='" + time + '\'' +
                "| status='" + status + '\'';
    }
}
