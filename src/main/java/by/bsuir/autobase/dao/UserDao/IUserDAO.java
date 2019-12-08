package by.bsuir.autobase.dao.UserDao;

import by.bsuir.autobase.entity.User;

/**
 * The interface User dao.
 */
public interface IUserDAO {
    /**
     * Gets user.
     *
     * @param name     the name
     * @param password the password
     * @return the user
     */
    User getUser (String name, String password);

    /**
     * Add user.
     *
     * @param name     the name
     * @param password the password
     */
    void addUser(String name, String password);

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    User getUserByName (String name);
}
