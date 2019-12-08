package by.bsuir.autobase.dao.VehicleDao;

import by.bsuir.autobase.dao.VehicleDB;
import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.Vehicle;
import by.bsuir.autobase.dao.DaoFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.ArrayList;

/**
 * The type Vehicle dao.
 */
public class VehicleDAO implements IVehicleDAO {

    public ArrayList<Vehicle> getVehicles() {
        return VehicleDB.select();
    }

    public Vehicle getVehicle (int id)
    {
        return VehicleDB.selectOne(id);
    }

    public void addVehicle(String make, String model, double price, double fuelConsumption,
                           int power, int year, FuelType fuelType) {
        VehicleDB.insert(new Vehicle(make, model, price, fuelConsumption, power, year, fuelType));
    }

    public void editVehicle(int id, String make, String model, double price, double fuelConsumption,
                           int power, int year, FuelType fuelType) {
        VehicleDB.update(new Vehicle(id, make, model, price, fuelConsumption, power, year, fuelType));
    }

    public void deleteVehicle(int id)
    {
        VehicleDB.delete(id);
    }

}
