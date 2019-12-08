package by.bsuir.autobase.dao;

import by.bsuir.autobase.dao.UserDao.UserDAO;
import by.bsuir.autobase.dao.VehicleDao.VehicleDAO;

public class DaoFactory {

    private static VehicleDAO vehicleDAO = new VehicleDAO();
    private static UserDAO userDAO = new UserDAO();

    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }
    public static UserDAO getUserDAO()
    {
        return userDAO;
    }
}
