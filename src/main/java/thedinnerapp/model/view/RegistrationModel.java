package thedinnerapp.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import thedinnerapp.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationModel {
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String pass;
    private String pass2;

}
