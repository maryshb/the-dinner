package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.IUserDAO;
import thedinnerapp.model.User;
import thedinnerapp.model.view.RegistrationModel;
import thedinnerapp.services.IUserService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IUserDAO userDAO;


    @Override
    public void authenticate(User user) {
        User userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());
        if(userFromDatabase == null) {
            return;
        }

        if(user.getPass().equals(userFromDatabase.getPass())){
            this.sessionObject.setLoggedUser(userFromDatabase);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }

    @Override
    public boolean register(RegistrationModel registrationModel) {
        if(this.userDAO.getUserByLogin(registrationModel.getLogin()) != null ) {
            return false;
        }
        User newUser = new User(0, registrationModel.getName(), registrationModel.getLastname(), registrationModel.getLogin(), registrationModel.getEmail(), registrationModel.getPass(), User.Role.USER);
        return this.userDAO.persistUser(newUser);
    }
}
