package TrelloClone.api;

import TrelloClone.domain.Comment;
import TrelloClone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/run")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/tasks/{taskId}/comments")
    ResponseEntity<List<Comment>> getCommentsByTaskId(@PathVariable(value="taskId") Long taskId) {
        if(commentService.getCommentsByTaskId(taskId) == null) {
            throw new RuntimeException("Not found Task with id = " + taskId);
        }
        List<Comment> comments = commentService.getCommentsByTaskId(taskId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{commentId}")
    //Will fetch just one comment based on comment id.
    ResponseEntity<Comment> getCommentByCommentId(@PathVariable Long commentId) {
        if(commentService.getCommentByCommentId(commentId) == null) {
            throw new RuntimeException("Not found Comment with id = " + commentId);
        }
        Comment comment = commentService.getCommentByCommentId(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/tasks/{taskId}/comments")
    //Create a comment for a particular task
    ResponseEntity<Comment> createComment(@PathVariable Long taskId, @RequestBody Comment comm) {
        if(commentService.createComment(taskId, comm) == null) {
            throw new RuntimeException("Task not found with id = " +taskId);
        }
        Comment comment = commentService.createComment(taskId, comm);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
