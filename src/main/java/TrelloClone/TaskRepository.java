package TrelloClone;

import TrelloClone.domain.Task;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called taskRepository
// CRUD refers Create, Read, Update, Delete
public interface TaskRepository extends CrudRepository<Task, Long> {
}
