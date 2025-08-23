package projects.repo;

import projects.Exception.TaskNotFoundException;
import projects.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepo<T extends Task> {

    private final List<T> tasks;

    public TaskRepo() {
        tasks = new ArrayList<>();
    }

    public void save(T task) {
        if (task == null) {
            throw new IllegalArgumentException("Tasks cannot be null");
        }
        if(!isUniqueId(task.getId())) {
            throw new IllegalArgumentException("Task with id " + task.getId() + " already exists");
        }
        tasks.add(task);
    }

    public void deleteByID(Integer id) throws TaskNotFoundException {
        boolean removed = tasks.removeIf(task -> task.getId().equals(id));

        if(!removed) throw new TaskNotFoundException("Task with " + id + " id not found");
    }

    public Optional<T> findById(Integer id) {
        for (T task : tasks) {
            if (task.getId().equals(id)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    public List<T> findAll() {
        return tasks;
    }

    //HelperMethod
    private boolean isUniqueId(Integer id) {
        for (T task : tasks) {
            if (task.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
