package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.IUserDAO;
import thedinnerapp.model.User;
import thedinnerapp.model.view.RegistrationModel;
import thedinnerapp.services.IUserService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    private SessionObject sessionObject;
    private IUserDAO userDAO;

    @Autowired
    public UserServiceImpl(SessionObject sessionObject, IUserDAO userDAO) {
        this.sessionObject = sessionObject;
        this.userDAO = userDAO;
    }

    private static final int logRounds = 12;

    @Override
    public void authenticate(User user) {
        User userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());
        if (userFromDatabase == null) {
            return;
        }

        if (checkPassword(user.getPass(), userFromDatabase.getPass())) {
            this.sessionObject.setLoggedUser(userFromDatabase);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }

    @Override
    public boolean register(RegistrationModel registrationModel) {
        if (this.userDAO.getUserByLogin(registrationModel.getLogin()) != null) {
            return false;
        }
        User newUser = new User(0, registrationModel.getName(), registrationModel.getLastname(), registrationModel.getLogin(),
                registrationModel.getEmail(), hashPassword(registrationModel.getPass()), User.Role.USER);

        return this.userDAO.persistUser(newUser);
    }

    @Override
    public String hashPassword(String plainTextPassword) {
        return (BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(logRounds)));
    }

    @Override
    public boolean checkPassword(String plainTextPassword, String storedHash) {
        if (storedHash == null || !storedHash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        return (BCrypt.checkpw(plainTextPassword, storedHash));
    }
}
