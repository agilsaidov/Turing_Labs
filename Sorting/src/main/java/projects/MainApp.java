package projects;


import static projects.Sorting.*;

public class MainApp {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 20, 3.8, "Computer Science"),
                new Student("Brian", 22, 3.5, "Mechanical Engineering"),
                new Student("Catherine", 21, 3.9, "Electrical Engineering"),
                new Student("David", 23, 3.2, "Business Administration"),
                new Student("Emily", 19, 3.7, "Mathematics")
        };

        sortByAge(students);
        System.out.println("Sorted by Age (ascending):");
        for (Student student : students) {
            System.out.println(student);
        }

        sortByGpa(students);
        System.out.println("\nSorted by GPA (descending):");
        for (Student student : students) {
            System.out.println(student);
        }

        sortByName(students);
        System.out.println("\nSorted by Name (alphabetical):");
        for (Student student : students) {
            System.out.println(student);
        }


    }
}