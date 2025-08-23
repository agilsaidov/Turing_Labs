package projects.model;

import projects.enumeration.TaskStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private Integer id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean isCompleted;
    private TaskStatus taskStatus;

    public Task(Integer id, String title, String description, LocalDateTime creationDate, boolean isCompleted, TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.isCompleted = isCompleted;
        this.taskStatus = taskStatus;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted &&
                Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(creationDate, task.creationDate) &&
                Objects.equals(taskStatus, task.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, creationDate, isCompleted, taskStatus);
    }

    @Override
    public String toString() {
        return "Task" +
                "|id=" + id +
                "| title='" + title + '\'' +
                "| description='" + description + '\'' +
                "| creationDate=" + creationDate +
                "| isCompleted=" + isCompleted +
                "| taskStatus=" + taskStatus +
                '|';
    }
}
