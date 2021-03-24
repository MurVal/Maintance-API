package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryDao implements TaskDao{
    private final AtomicLong currentId = new AtomicLong(0);

    private final Map<Long,Task> database = new HashMap<>();

    @Override
    public void addTask(Task task) {

        database.put(task.getId(),task);
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Optional<Task> getTaskById(long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public void editTask(int id, Task task) {

    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public long getNewId(){
        return currentId.incrementAndGet();
    }
}
