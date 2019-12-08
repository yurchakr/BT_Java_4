package by.bsuir.autobase.dao;

import by.bsuir.autobase.dao.UserDao.UserDAO;
import by.bsuir.autobase.dao.VehicleDao.VehicleDAO;

/**
 * The type Dao factory.
 */
public class DaoFactory {

    private static VehicleDAO vehicleDAO = new VehicleDAO();
    private static UserDAO userDAO = new UserDAO();

    /**
     * Gets vehicle dao.
     *
     * @return the vehicle dao
     */
    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }

    /**
     * Gets user dao.
     *
     * @return the user dao
     */
    public static UserDAO getUserDAO()
    {
        return userDAO;
    }
}
