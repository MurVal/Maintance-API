package bg.murval.maintenanceapi.controllers;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
import bg.murval.maintenanceapi.services.TaskService;
import bg.murval.maintenanceapi.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(final TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping(path = "{id}")
    public Task getTaskById(@PathVariable final long id){
        Optional<Task> task = taskService.getTaskById(id);
        //todo null error
        return task.orElse(null);
    }

    @PostMapping("/")
    public void addTask(@RequestBody final TaskRequest task){
        taskService.addTask(task);
    }
    @PutMapping(path = "{id}/{status}")
    public void updateTask(@PathVariable final long id, @PathVariable final Status status){
        taskService.updateTask(id,status);
    }
    @PutMapping(path = "{id}")
    public void editTask(@PathVariable final long id, @RequestBody final TaskRequest taskRequest){
        taskService.editTask(id,taskRequest);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTaskById(@PathVariable final long id){
        taskService.deleteTask(id);
    }

}
