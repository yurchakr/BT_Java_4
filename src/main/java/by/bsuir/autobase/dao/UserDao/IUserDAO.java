package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.entity.User;

public interface IUserDAO {
    User getVehicle (String name, String password);
    void addVehicle(String name, String password);
}
