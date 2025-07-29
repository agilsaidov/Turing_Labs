package sub_classes;

import interfaces.Notifiable;
import interfaces.Reportable;
import super_class.User;

import java.util.Arrays;

public class Patient extends User implements Notifiable, Reportable {

    private String[] symptoms;
    private String diagnosis;
    private Appointment[] appointments;
    private int appointmentCount;
    private int symptomCount;

    public Patient(int id, String name, String email, String phone) {
        super(id, name, email, phone);
    }


    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }


    public void addAppointment(Appointment appointment) {
        if(appointment == null) {
            System.out.println("Given appointment is null!");
            return;
        }
        if(appointmentCount == 10) {
            System.out.println("No more appointment can be added!");
        }
        Appointment temp[] = new Appointment[++appointmentCount];
        for(int i = 0; i < appointmentCount-1; i++) {
            temp[i] = appointments[i];
        }
        temp[appointmentCount-1] = appointment;
        appointments = temp;
    }


    public void addSymptom(String symptom) {
        if(symptom == null) {
            System.out.println("Given symptom is null!");
            return;
        }
        String[] temp = new String[++symptomCount];
        for(int i = 0; i < symptomCount-1; i++) {
            temp[i] = symptoms[i];
        }
        temp[symptomCount-1] = symptom;
        symptoms = temp;
    }


    @Override
    public void sendNotification(String message) {
        System.out.println(message);
    }


    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient Report for " + getName() + "\n");
        sb.append("Diagnosis: " + diagnosis + "\n");
        sb.append("Symptoms:" + Arrays.toString(symptoms) + "\n");
        sb.append("Upcoming Appointment(s): " + printAppointmentData());

        return sb.toString();
    }


    @Override
    public void printInfo() {
        System.out.println("Patient Info: "
                    +"\nName: " + getName()
                    +"\nEmail: " + getEmail()
                    +"\nPhone: " + getPhone()
                    +"\nDiagnosis: " + diagnosis);
    }

    //Helper method
    private String printAppointmentData(){
        if(appointments == null) {
            return "No appointments found!";
        }
        StringBuilder sb = new StringBuilder();
        for(Appointment a : appointments) {
            sb.append("Appointment of Dr." + a.getDoctorName() + " and patient " + getName() + "\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Patient " +
                super.toString() +
                "| symptoms=" + Arrays.toString(symptoms) +
                "| diagnosis='" + diagnosis + '\'' +
                "| appointments=" + printAppointmentData();
    }
}
