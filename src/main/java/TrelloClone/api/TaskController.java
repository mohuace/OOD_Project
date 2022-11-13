package TrelloClone.api;

import TrelloClone.model.Task;
import TrelloClone.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/tasks/{taskId}")
    ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Task modifiedTask = taskService.getTaskById(taskId);
        if(modifiedTask == null) {
            throw new RuntimeException("Not found Task with id = " +taskId);
        }
        return new ResponseEntity<>(modifiedTask, HttpStatus.OK);
    }

    @PostMapping("/tasks/create")
    //Create task --> either with empty
    Long createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    @PutMapping("/tasks/modify")
    //Any existing task will be modified.
    ResponseEntity<Task> modifyTask(@RequestBody Task task) {
        //For modify task, do we update the timestamp? ---> we can do that in the history table.
        Task modifiedTask = taskService.modifyTask(task);
        if(modifiedTask == null) {
            throw new RuntimeException("Either the User or TaskID doesn't exist");
        }
        return new ResponseEntity<>(modifiedTask, HttpStatus.OK);
    }

    //Find all history of the task using Spring Data JPA envers.
    @GetMapping("/tasks/{id}/getHistory")
    List<Task> getHistory(@PathVariable Long id) {
        return taskService.getHistory(id);
    }

    //Undo a task.
    @PostMapping("/tasks/{id}/undo")
    ResponseEntity<Task> undoTask(@PathVariable Long id) {
        Task undoTask = taskService.undoTask(id);
        if(undoTask == null) {
            throw new RuntimeException("TaskID doesn't exist");
        }
        return new ResponseEntity<>(undoTask, HttpStatus.OK);
    }
    @DeleteMapping("/tasks/{taskId}")
    //Delete task based on taskId
    ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        boolean isDeleted = taskService.deleteTask(taskId);
        if(!isDeleted) {
            throw new RuntimeException("Task not found with id ="+taskId);
        }
        return new ResponseEntity<>("Task Deleted", HttpStatus.OK);
    }
}
