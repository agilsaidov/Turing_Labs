package projects;

import projects.Exception.TaskNotFoundException;
import projects.enumeration.TaskStatus;
import projects.model.DeadlineTask;
import projects.model.Task;
import projects.model.User;
import projects.processor.EmailTaskProcessor;
import projects.service.TaskService;
import projects.service.TaskServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class MainApp {
    private static TaskService taskService = new TaskServiceImpl();
    private static EmailTaskProcessor emailProcessor = new EmailTaskProcessor();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        User user = new User(1234, "Aqil Sagidov");
        System.out.println("Welcome, " + user.getName() + "!");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addRegularTask();
                    break;
                case 2:
                    addDeadlineTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    findTask();
                    break;
                case 5:
                    listAllTasks();
                    break;
                case 6:
                    processTasks();
                    break;
                case 7:
                    checkDeadlines();
                    break;
                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== TASK MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Regular Task");
        System.out.println("2. Add Deadline Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Find Task by ID");
        System.out.println("5. List All Tasks");
        System.out.println("6. Process Tasks (Send Emails)");
        System.out.println("7. Check Deadlines");
        System.out.println("8. Exit");
        System.out.println("==============================");
    }

    private static void addRegularTask() {
        System.out.println("\n--- Add Regular Task ---");

        int id = getIntInput("Enter task ID: ");
        String title = getStringInput("Enter task title: ");
        String description = getStringInput("Enter task description: ");

        Task task = new Task(
                id,
                title,
                description,
                LocalDateTime.now(),
                false,
                TaskStatus.NEW
        );

        taskService.addTask(task);
    }

    private static void addDeadlineTask() {
        System.out.println("\n--- Add Deadline Task ---");

        int id = getIntInput("Enter task ID: ");
        String title = getStringInput("Enter task title: ");
        String description = getStringInput("Enter task description: ");

        System.out.println("Enter deadline date and time (YYYY-MM-DDTHH:MM:SS): ");
        String deadlineInput = scanner.nextLine();
        LocalDateTime deadline = LocalDateTime.parse(deadlineInput);

        DeadlineTask task = new DeadlineTask(
                id,
                title,
                description,
                LocalDateTime.now(),
                false,
                TaskStatus.NEW,
                deadline
        );

        taskService.addTask(task);
        task.checkDeadline(); // Check if deadline has already passed
    }

    private static void removeTask() {
        System.out.println("\n--- Remove Task ---");
        int id = getIntInput("Enter task ID to remove: ");
        try {
            taskService.removeTask(id);
        }catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void findTask() {
        System.out.println("\n--- Find Task ---");
        int id = getIntInput("Enter task ID to find: ");

        Optional<Task> task = taskService.findTaskById(id);
        if (task.isPresent()) {
            System.out.println("Task found: " + task.get());
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    private static void listAllTasks() {
        System.out.println("\n--- All Tasks ---");
        var tasks = taskService.listAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void processTasks() {
        System.out.println("\n--- Process Tasks ---");
        var tasks = taskService.listAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks to process.");
        } else {
            for (Task task : tasks) {
                emailProcessor.processTask(task);
            }
            System.out.println("All tasks processed.");
        }
    }

    private static void checkDeadlines() {
        System.out.println("\n--- Check Deadlines ---");
        var tasks = taskService.listAllTasks();

        boolean foundDeadlineTask = false;

        for (Task task : tasks) {
            if (task instanceof DeadlineTask) {
                foundDeadlineTask = true;
                DeadlineTask deadlineTask = (DeadlineTask) task;
                deadlineTask.checkDeadline();
            }
        }

        if (!foundDeadlineTask) {
            System.out.println("No deadline tasks found.");
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}