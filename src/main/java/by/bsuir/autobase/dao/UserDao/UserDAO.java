package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.dao.UserDB;
import by.bsuir.autobase.entity.User;

public class UserDAO {
    public User getUser (String name, String password)
    {
        return UserDB.selectOne(name, password);
    }

    public User getUserByName (String name)
    {
        return UserDB.selectOneByName(name);
    }

    public void addUser(String name, String password) {
        UserDB.insert(new User(name, password));
    }
}
