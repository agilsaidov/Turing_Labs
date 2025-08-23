package projects.service;

import projects.Exception.TaskNotFoundException;
import projects.model.Task;
import projects.repo.TaskRepo;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    TaskRepo<Task> taskRepo = new TaskRepo<>();

    @Override
    public void addTask(Task task) {
        try {
            taskRepo.save(task);
            System.out.println("Task " + task.getTitle() + " added added successfully");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeTask(Integer id) {
        try {
            taskRepo.deleteById(id);
            System.out.println("Task with Id " + id + " removed successfully");

        }catch (TaskNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Optional<Task> findTaskById(Integer id) {
        return taskRepo.findById(id);
    }

    @Override
    public List<Task> listAllTasks() {
        return taskRepo.findAll();
    }
}
