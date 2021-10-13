package thedinnerapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String pass;
    private Role role;

    public User() {

    }

    public User(int id, String name, String lastname, String login, String email, String pass, Role role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }




    public int getId() { return id; }

    public String getFirstName() { return name; }

    public String getLastName() { return lastname; }

    public String getLogin() { return login; }

    public String getEmail() { return email; }

    public String getPass() { return pass; }

    public Role getRole() { return role; }

    public void setId(int id) { this.id = id; }

    public void setFirstName(String firstName) { this.name = firstName; }

    public void setLastName(String lastName) { this.lastname = lastName; }

    public void setLogin(String login) { this.login = login; }

    public void setEmail(String email) { this.email = email; }

    public void setPass(String pass) { this.pass = pass; }

    public void setRole (Role role) { this.role = role; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                '}';
    }

    public enum Role {
        ADMIN,
        USER
    }
}


