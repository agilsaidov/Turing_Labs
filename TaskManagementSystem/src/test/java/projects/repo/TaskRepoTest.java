package projects.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.Exception.TaskNotFoundException;
import projects.enumeration.TaskStatus;
import projects.model.DeadlineTask;
import projects.model.Task;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepoTest {

    Task task1;
    Task task2;
    DeadlineTask task3;
    TaskRepo repo;

    @BeforeEach
    void setUp() {
        task1 = new Task(123,"Hello","Say Hello World", LocalDateTime.now(),false, TaskStatus.NEW);
        task2 = null;
        task3 = new DeadlineTask(123,"Coding",
                "I am gonna write code", LocalDateTime.now(),false,
                TaskStatus.IN_PROGRESS,LocalDateTime.of(2025,9,19,18,20));

        repo = new TaskRepo();
    }

    @Test
    void saveThrowsException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> repo.save(task2));
        assertEquals("Tasks cannot be null", e.getMessage());
    }

    @Test
    void saveWithSameId() {
        repo.save(task1);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> repo.save(task3));
        assertEquals("Task with id " + task1.getId() + " already exists", e.getMessage());
    }

    @Test
    void deleteByIdTaskNotFound() {
        TaskNotFoundException e = assertThrows(TaskNotFoundException.class, () -> repo.deleteById(task1.getId()));
        assertEquals("Task with " + task1.getId() + " id not found", e.getMessage());
    }

    @Test
    void findByIdTaskNotFound() {
        assertEquals(Optional.empty(), repo.findById(task1.getId()));
    }

    @Test
    void findByIdTaskFound() {
        repo.save(task1);
        assertEquals(Optional.of(task1), repo.findById(task1.getId()));
    }

    @Test
    void findByIdAfterDeleteReturnsEmpty() {
        repo.save(task1);
        assertDoesNotThrow(() -> repo.deleteById(task1.getId()));
        assertEquals(Optional.empty(), repo.findById(task1.getId()));
    }


}