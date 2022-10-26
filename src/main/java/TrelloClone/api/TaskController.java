package TrelloClone.api;

import TrelloClone.domain.Task;
import TrelloClone.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/run")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    List<Task> all() {
        return taskService.showBoard();
    }

    @PostMapping("/tasks/create")
    Long newTask() {
        return taskService.createTask();
    }
    @PostMapping("/tasks/modify")
    ResponseEntity<Task> modifyTask(@RequestBody Task task) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/run/tasks/modify").toUriString());
        try {
            return ResponseEntity.created(uri).body(taskService.modifyTask(task));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
    // end::get-aggregate-root[]

//    @PostMapping("/tasks")
//    Task newEmployee(@RequestBody Task newTask) {
//        return taskRepository.save(newTask);
//    }
//
    @DeleteMapping("/tasks/{taskId}")
    ResponseEntity<Boolean> deleteTask(@PathVariable Long taskId) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/run/tasks").toUriString());

        return ResponseEntity.created(uri).body(taskService.deleteTask(taskId));
    }
}
