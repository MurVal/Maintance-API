package bg.murval.maintenanceapi.services;

import bg.murval.maintenanceapi.exceptions.NoTaskException;
import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.repository.TaskRepository;
import bg.murval.maintenanceapi.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void editTask(final long id, final Task taskRequest) {
        final Task task = getTaskById(id);

        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());

        taskRepository.save(task);
    }

    public void updateTask(final long id, final Status status) {
        final Task task = getTaskById(id);
        task.setStatus(status);
        taskRepository.save(task);
    }

    public void addTask(final Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(final long id) {
        return taskRepository.findById(id).orElseThrow(NoTaskException::new);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(final long id) {
        taskRepository.deleteById(id);
    }
}
