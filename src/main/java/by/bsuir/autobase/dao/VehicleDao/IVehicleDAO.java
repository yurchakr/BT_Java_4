package by.bsuir.autobase.dao.VehicleDao;

import java.io.IOException;
import java.util.ArrayList;

import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.Vehicle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

public interface IVehicleDAO {

    ArrayList<Vehicle> getVehicles() throws ParserConfigurationException, SAXException, IOException, XMLStreamException;
    void deleteVehicle(int id);
    void editVehicle(int id, String make, String model, double price, double fuelConsumption,
                            int power, int year, FuelType fuelType);
    Vehicle getVehicle (int id);
    void addVehicle(String make, String model, double price, double fuelConsumption,
                           int power, int year, FuelType fuelType);
}
