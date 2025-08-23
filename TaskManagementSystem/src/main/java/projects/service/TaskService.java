package projects.service;

import projects.Exception.TaskNotFoundException;
import projects.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void addTask(Task task);

    void removeTask(Integer id) throws TaskNotFoundException;

    Optional<Task> findTaskById(Integer id);

    List<Task> listAllTasks();
}
