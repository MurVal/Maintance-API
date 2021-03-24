package bg.murval.maintenanceapi;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.models.TaskRequest;
import bg.murval.maintenanceapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/task")
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public void addTask(@RequestBody TaskRequest task){
        taskService.addTask(task);
    }

    @PutMapping(path = "{id}")
    public void setState(@PathVariable int id){

    }
    @GetMapping(path = "{id}")
    private Task getTaskById(@PathVariable long id){
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()){
            return task.get();
        }
        else{
            return null;
            //todo null error
        }
    }
}
