package TrelloClone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
public class Task {

    @Autowired
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long taskId;

    //Can think of keeping state as Enum;
    private String state;

    //What would be the type of assignedTo?? if User, how will we implement.
    private String assignedTo;
    private String description;

    private Timestamp created;
    private Timestamp completed;

    public Timestamp getCompleted() {
        return completed;
    }

    public void setCompleted(Timestamp completed) {
        this.completed = completed;
    }

    public Task(String state, String assignedTo, String description, Timestamp created) {
        this.state = state;
        this.assignedTo = assignedTo;
        this.description = description;
        this.created = created;
        this.completed = completed;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Long getTaskId() {
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

    //Equals method to be implemented.

    @Override
    public String toString() {
        return "Task: "+this.taskId+"Description: "+this.description+" Assigned to: "+this.assignedTo;
    }
}
