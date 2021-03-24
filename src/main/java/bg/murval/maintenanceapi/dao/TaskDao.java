package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;

import java.util.List;

public interface TaskDao {

    void addTask(TaskRequest task);

    List<Task> getTasks();

    Task getTaskById(int id);

    void editTask(int id, Task task);

    void deleteTask(int id);
}
