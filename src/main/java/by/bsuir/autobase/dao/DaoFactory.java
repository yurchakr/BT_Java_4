package by.bsuir.autobase.dao;

import by.bsuir.autobase.dao.VehicleDao.VehicleDAO;

public class DaoFactory {

    private static VehicleDAO vehicleDAO = new VehicleDAO();

    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }
}
