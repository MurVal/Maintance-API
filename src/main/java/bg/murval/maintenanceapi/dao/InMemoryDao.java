package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryDao implements TaskDao {
    private final AtomicLong currentId = new AtomicLong(0);
    private final Map<Long, Task> database = new HashMap<>();

    @Override
    public void addTask(final Task task) {
        this.database.put(task.getId(), task);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Task> getTaskById(final long id) {
        return Optional.ofNullable(database.get(id));
    }


    @Override
    public void deleteTask(final long id) {
        this.database.remove(id);
    }

    @Override
    public long getNewId() {
        return currentId.incrementAndGet();
    }
}
