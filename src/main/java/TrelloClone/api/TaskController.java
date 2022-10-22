package TrelloClone.api;

import TrelloClone.TaskRepository;
import TrelloClone.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/run")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    Iterable<Task> all() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
//        if(taskRepository.existsById(newTask.getTaskId())) {
//            return newTask;
//        }
        return taskRepository.save(newTask);
    }
    // end::get-aggregate-root[]

//    @PostMapping("/tasks")
//    Task newEmployee(@RequestBody Task newTask) {
//        return taskRepository.save(newTask);
//    }
//
    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
