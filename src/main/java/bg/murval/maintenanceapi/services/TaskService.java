package bg.murval.maintenanceapi.services;


import bg.murval.maintenanceapi.dao.TaskDao;
import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
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

    //За да променим title and description
    public void editTask(final long id,final TaskRequest taskRequest) {
        Optional<Task> task = getTaskById(id);
        task.ifPresent(t -> {
            t.setName(taskRequest.getName());
            t.setDescription(taskRequest.getDescription());
            t.setStatus(taskRequest.getStatus());
        });
    }
    //To update status
    public void updateTask(final long id, final Status status) {
        getTaskById(id).ifPresent(value -> value.setStatus(status));
    }

    public void addTask(final TaskRequest taskRequest) {
        final long id = taskDao.getNewId();
        final Task task = new Task(id, taskRequest.getName(), taskRequest.getDescription(), taskRequest.getStatus());
        taskDao.addTask(task);
    }

    public Optional<Task> getTaskById(final long id) {
        return taskDao.getTaskById(id);
    }

    public List<Task> getAllTasks() {
        return taskDao.getTasks();
    }

    public void deleteTask(final long id){
        taskDao.deleteTask(id);
    }
}
