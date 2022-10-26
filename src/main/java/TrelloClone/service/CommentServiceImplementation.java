package TrelloClone.service;

import TrelloClone.domain.Comment;
import TrelloClone.domain.Task;
import TrelloClone.repo.CommentRepository;
import TrelloClone.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private TaskRepository taskRepo;


    @Override
    //We are trying to find all comments using the task id.
    public List<Comment> getCommentsByTaskId(Long taskId) {
        if(!taskRepo.existsByTaskId(taskId)) {
            return null;
        }
        List<Comment> comments = commentRepo.findByTaskTaskId(taskId);
        return comments;
    }

    @Override
    public Comment getCommentByCommentId(Long commentId) {
        Comment comment = commentRepo.findByCommentId(commentId);
        return comment;
    }

    @Override
    //First find the task using the taskId and then save its reference in comment object.
    public Comment createComment(Long taskId, Comment comment) {
        if(!taskRepo.existsByTaskId(taskId)) return null;

        Task task = taskRepo.findByTaskId(taskId);
        comment.setTask(task);
        return commentRepo.save(comment);
    }
}
