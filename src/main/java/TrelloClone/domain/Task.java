package TrelloClone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long taskId;

    //Can think of keeping state as Enum;
    public String state;
    public String assignedTo;
    public String description;
    public String comments;

    Task() {}

    public Task(String state, String assignedTo, String description, String comments) {
        this.state = state;
        this.assignedTo = assignedTo;
        this.description = description;
        this.comments = comments;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    //Equals method to be implemented.


    @Override
    public String toString() {
        return "Task: "+this.taskId+"Description: "+this.description+" Assigned to: "+this.assignedTo;
    }
}
