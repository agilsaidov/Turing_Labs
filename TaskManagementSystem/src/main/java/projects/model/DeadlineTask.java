package projects.model;

import projects.enumeration.TaskStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task{
    private LocalDateTime deadline;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public DeadlineTask(Integer id, String title, String description, LocalDateTime creationDate, boolean isCompleted, TaskStatus taskStatus, LocalDateTime deadline) {
        super(id, title, description, creationDate, isCompleted, taskStatus);
        this.deadline = deadline;

    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void checkDeadline() {
        if (isDeadlinePassed()) {
            System.out.println("DEADLINE PASSED for task: " + getTitle() + " (Due: " + formatter.format(deadline) + ")");
        }
    }

    public boolean isDeadlinePassed() {
        return LocalDateTime.now().isAfter(deadline) && !isCompleted();
    }

    @Override
    public String toString() {
        String result = super.toString() + " Deadline: ";
        if (isDeadlinePassed()) {
            result += "OVERDUE!";
        }else{
            result += formatter.format(deadline);
        }

        return result;
    }
}
