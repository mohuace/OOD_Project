package TrelloClone.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {
    @Id @GeneratedValue
    //Is getter setter required for id?
    private long id;
    public String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
