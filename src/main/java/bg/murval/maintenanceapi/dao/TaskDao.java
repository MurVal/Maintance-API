package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;

import java.util.List;
import java.util.Optional;

public interface TaskDao {

    void addTask(Task task);

    List<Task> getTasks();

    Optional<Task> getTaskById(long id);

    void editTask(int id, Task task);

    void deleteTask(int id);

    long getNewId();
}
