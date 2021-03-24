package bg.murval.maintenanceapi;

import bg.murval.maintenanceapi.models.Task;
import bg.murval.maintenanceapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

/*    @PostMapping()
    public void addState(@RequestBody Task task){
        taskService.addState();
    }*/

    @PutMapping(path = "{id}")
    public void setState(@PathVariable int id){

    }

}
