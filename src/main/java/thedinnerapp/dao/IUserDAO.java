package thedinnerapp.dao;

import thedinnerapp.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    boolean persistUser(User user);

}
