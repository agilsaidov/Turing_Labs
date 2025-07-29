package sub_classes;

import interfaces.Notifiable;
import interfaces.Reportable;
import interfaces.Schedulable;
import super_class.User;

import java.util.Arrays;


public class Doctor extends User implements Notifiable, Reportable, Schedulable {

    private String specialization;

    private String[] schedule;

    private Appointment[] appointments;

    private int appointmentCount;


    public Doctor(int id, String name, String email, String phone, String specialization) {
        super(id, name, email, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String[] getSchedule() {
        return schedule;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }



    public void addAppointment(Appointment appointment) {
        if(appointment == null) {
            System.out.println("Given appointment is null. Appointment will not be added.");
            return;
        }
        if(appointmentCount ==7) {
            System.out.println("No more appointment can be added. Appointment isn't added.");
            return;
        }
        Appointment[] temp = new Appointment[++appointmentCount];
        for(int i = 0; i < appointmentCount-1; i++) {
            temp[i] = appointments[i];
        }
        temp[appointmentCount-1] = appointment;
        appointments = temp;
    }


    @Override
    public void sendNotification(String message) {
        System.out.println("Message from Dr. " + getName() + ": " + message);
    }



    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder("Doctor Report for Dr. " + getName() + ":\n");
        sb.append("Specialization: ").append(specialization).append("\n");
        sb.append("Appointments:\n");
        sb.append(printAppointmentData()).append("\n");
        return sb.toString();
    }


    @Override
    public void assignSchedule(String[] days) {
        if(days == null || days.length == 0) {
            System.out.println("There are no assigned day(s)");
            return;
        }
        schedule = days;
    }

    @Override
    public void viewSchedule() {
        if(schedule == null || schedule.length == 0) {
            System.out.println("Schedule is empty");
            return;
        }
        System.out.println("Schedule for " + getName() + ": ");
        for(String day : schedule) {
            System.out.println(day);
        }
        System.out.println();
    }

    @Override
    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Doctor: " + getName() + "\n");
        sb.append("Specialization: " + specialization + "\n");
        sb.append("Email: " + getEmail() + "\n");
        sb.append("Phone: " + getPhone() + "\n");
        System.out.println(sb.toString());
    }

    //Helper method
    private String printAppointmentData(){
        if(appointments == null) {
            return "No appointments found!";
        }
        StringBuilder sb = new StringBuilder();
        for(Appointment a : appointments) {
            sb.append(" - Appointment of Dr." + getName() + " and patient " + a.getPatientName() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Doctor " +
                 super.toString() +
                "| specialization='" + specialization + '\'' +
                "| schedule=" + Arrays.toString(schedule) +
                "| appointments=" + appointments.toString() +
                "| appointmentCount=" + appointmentCount;
    }
}
