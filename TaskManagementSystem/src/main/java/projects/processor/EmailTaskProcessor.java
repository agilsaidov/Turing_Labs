package projects.processor;

import projects.model.Task;

public class EmailTaskProcessor extends AbstractTaskProcessor {

    @Override
    public void processTask(Task task) {
        System.out.println("Email sent for task " + task.getTitle());
    }
}
