package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import java.util.List;
import java.util.Optional;

public interface TaskDao {

    long getNewId();

    List<Task> getTasks();

    Optional<Task> getTaskById(final long id);

    void addTask(final Task task);

    void deleteTask(final long id);
}
