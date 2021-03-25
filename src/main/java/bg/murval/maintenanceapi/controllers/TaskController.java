package bg.murval.maintenanceapi.controllers;

import bg.murval.maintenanceapi.interceptors.LoginRequired;
import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.services.TaskService;
import bg.murval.maintenanceapi.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "{id}")
    public Task getTaskById(@PathVariable final long id) {
        return taskService.getTaskById(id);
    }

    @LoginRequired
    @PostMapping("/")
    public void addTask(@RequestBody final Task task) {
        taskService.addTask(task);
    }

    @LoginRequired
    @PutMapping(path = "{id}/{status}")
    public void updateTask(@PathVariable final long id, @PathVariable final Status status) {
        taskService.updateTask(id, status);
    }

    @LoginRequired
    @PutMapping(path = "{id}")
    public void editTask(@PathVariable final long id, @RequestBody final Task task) {
        taskService.editTask(id, task);
    }

    @LoginRequired
    @DeleteMapping(path = "{id}")
    public void deleteTaskById(@PathVariable final long id) {
        taskService.deleteTask(id);
    }

}
