package TrelloClone.repo;

import TrelloClone.model.Task;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called taskRepository
// CRUD refers Create, Read, Update, Delete
public interface TaskRepository extends RevisionRepository<Task, Long, Integer>, JpaRepository<Task, Long> {
    Task findByTaskId(Long taskId);
    Boolean existsByTaskId(Long taskId);
    //List<Revisions<Long, Task>> findByRevisions(Long taskId);
}
