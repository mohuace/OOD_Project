package TrelloClone.service;

import TrelloClone.model.Task;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Long createTask(Task task);
    Task modifyTask(Task task);
    Boolean deleteTask(Long taskId);

    Task getTaskById(Long taskId);
    List<Task> showBoard();
    List<Task> getHistory(Long taskId);
    Task undoTask(Long id);
}
