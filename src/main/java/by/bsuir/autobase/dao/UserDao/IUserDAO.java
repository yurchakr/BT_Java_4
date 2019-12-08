package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.entity.User;

public interface IUserDAO {
    User getUser (String name, String password);
    void addUser(String name, String password);
    User getUserByName (String name);
}
