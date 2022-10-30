package TrelloClone.repo;

import TrelloClone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //Naming is pretty important here...If Task class has Id field then it should be named findByTaskId
    //Here, I have taskId as the id field so have to name it findByTaskTaskId.
    List<Comment> findByTaskTaskId(Long id);
    Comment findByCommentId(Long commentId);
}
