package thedinnerapp.model.view;

import thedinnerapp.model.User;

public class RegistrationModel {
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String pass;
    private String pass2;

    public RegistrationModel(String name, String lastname, String login, String email, String pass, String pass2){
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.pass2 = pass2;
    }

    public RegistrationModel () {

    }

    public String getName() { return name; }

    public String getLastname() { return lastname; }

    public String getLogin() { return login; }

    public String getEmail() { return email; }

    public String getPass() { return pass; }

    public String getPass2() { return pass2; }

    public void setName(String name) { this.name = name; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public void setLogin(String login) { this.login = login; }

    public void setEmail(String email) { this.email = email; }

    public void setPass(String pass) { this.pass = pass; }

    public void setPass2(String pass2) { this.pass2 = pass2; }




}
