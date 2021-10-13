package thedinnerapp.services;

import thedinnerapp.model.User;
import thedinnerapp.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
}
