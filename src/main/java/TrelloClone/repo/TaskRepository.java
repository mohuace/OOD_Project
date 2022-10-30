package TrelloClone.repo;

import TrelloClone.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called taskRepository
// CRUD refers Create, Read, Update, Delete
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskId(Long taskId);
    Boolean existsByTaskId(Long taskId);
}
