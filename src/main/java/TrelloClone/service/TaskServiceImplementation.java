package TrelloClone.service;

import TrelloClone.repo.TaskRepository;
import TrelloClone.model.Task;
import TrelloClone.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Long createTask(Task task) {
        //A new task is created and a timestamp is added when the task gets created
        Timestamp t = new Timestamp(System.currentTimeMillis());
        task.setCreated(t);
        taskRepository.save(task);
        return task.getTaskId();
    }

    @Override
    public Task modifyTask(Task task) {
        //First get existing task and change only the ones for which values exist in the input param.
        Task existingTask = taskRepository.findByTaskId(task.getTaskId());
        if(task.getDescription() != null && !task.getDescription().equals("")) {
            existingTask.setDescription(task.getDescription());
        }
        if(task.getState() != null && !task.getState().equals("")) {
            existingTask.setState(task.getState());
        }
        if(task.getAssignedTo() != null && !task.getAssignedTo().equals("")) {
            existingTask.setAssignedTo(task.getAssignedTo());
        }
        //When task is equal to "Done", update the completion time.
        if(existingTask.getState().equalsIgnoreCase("Done")) {
            existingTask.setCompleted(new Timestamp(System.currentTimeMillis()));
        }

        boolean doesUserExist = false;
        //Check if the user we are adding exists in the list of users, otherwise don't add
        for(Users user: Users.values()) {
            if(user.name().equalsIgnoreCase(existingTask.getAssignedTo())) {
                doesUserExist = true;
            }
        }
        //If the user does not exist, do not update the task.
        if(!doesUserExist) {
            return null;
        }
        return taskRepository.save(existingTask);
    }

    @Override
    public Boolean deleteTask(Long taskId) {
        if(taskRepository.findByTaskId(taskId) != null) {
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }

    @Override
    public List<Task> showBoard() {
        return taskRepository.findAll();
    }
    @Override

    public Task getTaskById(Long taskId) {
        return taskRepository.findByTaskId(taskId);
    }
}
