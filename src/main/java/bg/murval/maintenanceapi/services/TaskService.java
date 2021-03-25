package bg.murval.maintenanceapi.services;


import bg.murval.maintenanceapi.dao.TaskDao;
import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskDao taskDao;

    public TaskService(final TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void editTask(final long id, final Task taskRequest) {
        final Optional<Task> task = getTaskById(id);
        task.ifPresent(t -> {
            t.setName(taskRequest.getName());
            t.setDescription(taskRequest.getDescription());
            t.setStatus(taskRequest.getStatus());
        });
    }

    public void updateTask(final long id, final Status status) {
        getTaskById(id).ifPresent(value -> value.setStatus(status));
    }

    public void addTask(final Task task) {
        task.setId(taskDao.getNewId());
        taskDao.addTask(task);
    }

    public Optional<Task> getTaskById(final long id) {
        return taskDao.getTaskById(id);
    }

    public List<Task> getAllTasks() {
        return taskDao.getTasks();
    }

    public void deleteTask(final long id) {
        taskDao.deleteTask(id);
    }
}
