import sub_classes.Appointment;
import sub_classes.Doctor;
import sub_classes.Patient;

public class MainApp {
    public static void main(String[] args) {

        // ----------------------------
        // Stage 1: Create Doctors
        // ----------------------------

        Doctor d1 = new Doctor(201, "Emily", "emily@hospital.com", "555-1234", "Neurology");
        Doctor d2 = new Doctor(202, "John", "john@hospital.com", "555-5678", "Cardiology");
        Doctor d3 = new Doctor(203, "Sarah", "sarah@hospital.com", "555-9999", "Pediatrics");

        System.out.println("\n--- Doctor Info ---");
        d1.printInfo();
        d2.printInfo();
        d3.printInfo();

        // ----------------------------
        // Stage 2: Assign Schedules
        // ----------------------------

        d1.assignSchedule(new String[]{"Monday", "Wednesday", "Friday"});
        d2.assignSchedule(new String[]{"Tuesday", "Thursday"});
        d3.assignSchedule(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});

        System.out.println("\n--- Doctor Schedules ---");
        d1.viewSchedule();
        d2.viewSchedule();
        d3.viewSchedule();

        // ----------------------------
        // Stage 3: Create Patients
        // ----------------------------

        Patient p1 = new Patient(301, "Alice", "alice@mail.com", "999-1111");
        Patient p2 = new Patient(302, "Bob", "bob@mail.com", "999-2222");
        Patient p3 = new Patient(303, "Clara", "clara@mail.com", "999-3333");
        Patient p4 = new Patient(304, "David", "david@mail.com", "999-4444");
        Patient p5 = new Patient(305, "Eve", "eve@mail.com", "999-5555");

        System.out.println("\n--- Adding Symptoms ---");
        p1.addSymptom("Headache");
        p1.addSymptom("Nausea");

        p2.addSymptom("Cough");
        p2.addSymptom("Fever");

        p3.addSymptom("Fatigue");
        p4.addSymptom("Stomach Pain");
        p5.addSymptom("Sneezing");


        // ----------------------------
        // Stage 4: Create Appointments
        // ----------------------------

        Appointment a1 = new Appointment(401, p1, d1, "2025-08-12", "10:00", "Scheduled");
        Appointment a2 = new Appointment(402, p2, d2, "2025-08-13", "11:00", "Scheduled");
        Appointment a3 = new Appointment(403, p3, d1, "2025-08-14", "14:00", "Scheduled");
        Appointment a4 = new Appointment(404, p4, d3, "2025-08-15", "09:30", "Scheduled");

        // ----------------------------
        // Stage 5: Assign Appointments to Doctors and Patients
        // ----------------------------

        d1.addAppointment(a1);
        d1.addAppointment(a3);
        d2.addAppointment(a2);
        d3.addAppointment(a4);

        p1.addAppointment(a1);
        p2.addAppointment(a2);
        p3.addAppointment(a3);
        p4.addAppointment(a4);

        // ----------------------------
        // Stage 6: Generate Reports
        // ----------------------------

        System.out.println("\n--- Patient Reports ---");
        System.out.println(p1.generateReport());
        System.out.println(p2.generateReport());

        System.out.println("\n--- Doctor Reports ---");
        System.out.println(d1.generateReport());
        System.out.println(d2.generateReport());

        // ----------------------------
        // Stage 7: Notifications
        // ----------------------------

        System.out.println("\n--- Notifications ---");
        p1.sendNotification("Your next appointment is tomorrow.");
        d1.sendNotification("Please review MRI results before next appointment.");

        // ----------------------------
        // Stage 8: toString() Output
        // ----------------------------

        System.out.println("\n--- Object Summaries (toString) ---");
        System.out.println(p1.toString());
        System.out.println(d1.toString());
        System.out.println(a1.toString());
    }
}
