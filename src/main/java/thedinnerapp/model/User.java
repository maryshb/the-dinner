package thedinnerapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "tuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String pass;
    private Role role;

    public User() {

    }

    public User(int userId, String name, String lastname, String login, String email, String pass, Role role) {
        this.userId = userId;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public enum Role {
        ADMIN,
        USER
    }
}


