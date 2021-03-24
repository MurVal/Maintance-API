package bg.murval.maintenanceapi.dao;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryDao implements TaskDao{
    private final Map<Integer,Task> database = new HashMap<Integer, Task>();

    @Override
    public void addTask(TaskRequest taskRequest) {
        final int lastId = database.keySet().stream().sorted().findFirst().orElse(0);
        Task tsk = new Task(lastId+1,taskRequest.getName(),taskRequest.getDescription(),taskRequest.getStatus());
        database.put(tsk.getId(),tsk);
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task getTaskById(int id) {


        return null;
    }

    @Override
    public void editTask(int id, Task task) {

    }

    @Override
    public void deleteTask(int id) {

    }
}
