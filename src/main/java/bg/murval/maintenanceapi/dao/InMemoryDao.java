package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryDao implements TaskDao {
    private final AtomicLong currentId = new AtomicLong(0);

    private final Map<Long, Task> database = new HashMap<>();

    @Override
    public void addTask(Task task) {

        database.put(task.getId(), task);
    }

    @Override
    public List<Task> getTasks() {
        List<Task> list = new ArrayList<>();
        database.forEach((id, task) -> list.add(task));
        return list;
    }

    @Override
    public Optional<Task> getTaskById(long id) {
        return Optional.ofNullable(database.get(id));
    }



    @Override
    public void deleteTask(long id) {
        database.remove(id);
    }

    @Override
    public long getNewId() {
        return currentId.incrementAndGet();
    }
}
