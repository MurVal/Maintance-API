package bg.murval.maintenanceapi.services;


import bg.murval.maintenanceapi.dao.TaskDao;
import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
import bg.murval.maintenanceapi.utils.Status;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    TaskDao taskDao;

    //За да променим title and description
    public void editTask(long id,) {
        Optional<Task> = getTaskById(id)
    }
    //To update status
    public void updateTask(long id, Status status) {
        getTaskById(id).ifPresent(value -> value.setStatus(status));
    }

    public void addTask(TaskRequest task) {
        final long id = taskDao.getNewId();
        taskDao.addTask(new Task(id, task.getName(), task.getDescription(), task.getStatus()));
    }

    public Optional<Task> getTaskById(long id) {
        return taskDao.getTaskById(id);
    }
}
