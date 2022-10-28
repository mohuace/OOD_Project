package TrelloClone.service;

import TrelloClone.domain.Task;

import java.util.List;

public interface TaskService {
    Long createTask(Task task);
    Task modifyTask(Task task);
    Boolean deleteTask(Long taskId);

    Task getTaskById(Long taskId);
    List<Task> showBoard();
}
