package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.dao.UserDB;
import by.bsuir.autobase.entity.User;

public class UserDAO {
    public User getVehicle (String name, String password)
    {
        return UserDB.selectOne(name, password);
    }

    public void addVehicle(String name, String password) {
        UserDB.insert(new User(name, password));
    }
}
