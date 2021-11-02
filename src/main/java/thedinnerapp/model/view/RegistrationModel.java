package thedinnerapp.model.view;

import lombok.Data;
import thedinnerapp.model.User;

@Data
public class RegistrationModel {
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String pass;
    private String pass2;

    public RegistrationModel(String name, String lastname, String login, String email, String pass, String pass2) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.pass2 = pass2;
    }

    public RegistrationModel() {

    }


}
