package TrelloClone.service;

import TrelloClone.domain.Task;

import java.util.List;

public interface TaskService {
    Long createTask();
    Task modifyTask(Task task);
    Boolean deleteTask(long taskId);
    List<Task> showBoard();
}
