package by.bsuir.autobase.dao.VehicleDao;

import java.io.IOException;
import java.util.ArrayList;

import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.Vehicle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

/**
 * The interface Vehicle dao.
 */
public interface IVehicleDAO {

    /**
     * Gets vehicles.
     *
     * @return the vehicles
     * @throws ParserConfigurationException the parser configuration exception
     * @throws SAXException                 the sax exception
     * @throws IOException                  the io exception
     * @throws XMLStreamException           the xml stream exception
     */
    ArrayList<Vehicle> getVehicles() throws ParserConfigurationException, SAXException, IOException, XMLStreamException;

    /**
     * Delete vehicle.
     *
     * @param id the id
     */
    void deleteVehicle(int id);

    /**
     * Edit vehicle.
     *
     * @param id              the id
     * @param make            the make
     * @param model           the model
     * @param price           the price
     * @param fuelConsumption the fuel consumption
     * @param power           the power
     * @param year            the year
     * @param fuelType        the fuel type
     */
    void editVehicle(int id, String make, String model, double price, double fuelConsumption,
                            int power, int year, FuelType fuelType);

    /**
     * Gets vehicle.
     *
     * @param id the id
     * @return the vehicle
     */
    Vehicle getVehicle (int id);

    /**
     * Add vehicle.
     *
     * @param make            the make
     * @param model           the model
     * @param price           the price
     * @param fuelConsumption the fuel consumption
     * @param power           the power
     * @param year            the year
     * @param fuelType        the fuel type
     */
    void addVehicle(String make, String model, double price, double fuelConsumption,
                           int power, int year, FuelType fuelType);
}
