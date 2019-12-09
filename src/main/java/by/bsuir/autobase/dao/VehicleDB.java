package by.bsuir.autobase.dao;

import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The type Vehicle db.
 */
public class VehicleDB {

        private static Logger log = Logger.getLogger(String.valueOf(VehicleDB.class));
        private static String url = "jdbc:mysql://localhost:3306/autobase?serverTimezone=Europe/Minsk&useSSL=false";
        private static String username = "root";
        private static String password = "root";

    /**
     * Select array list.
     *
     * @return the array list
     */
    public static ArrayList<Vehicle> select() {

            ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
            try{
                log.info("DB selecting routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles");
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String make = resultSet.getString(2);
                        String model = resultSet.getString(3);
                        double price = resultSet.getDouble(4);
                        double fuelConsumption = resultSet.getDouble(5);
                        int power = resultSet.getInt(6);
                        int year = resultSet.getInt(7);
                        FuelType fuelType = FuelType.valueOf(resultSet.getString(8));
                        Vehicle vehicle = new Vehicle(id, make, model, price, fuelConsumption, power, year, fuelType);
                        vehicles.add(vehicle);
                    }
                    log.info("Select: Successful");
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return vehicles;
        }

    /**
     * Select one vehicle.
     *
     * @param id the id
     * @return the vehicle
     */
    public static Vehicle selectOne(int id) {

            Vehicle vehicle = null;
            try{
                log.info("DB selecting one routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "SELECT * FROM vehicles WHERE id=?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setInt(1, id);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            String make = resultSet.getString(2);
                            String model = resultSet.getString(3);
                            double price = resultSet.getDouble(4);
                            double fuelConsumption = resultSet.getDouble(5);
                            int power = resultSet.getInt(6);
                            int year = resultSet.getInt(7);
                            FuelType fuelType = FuelType.valueOf(resultSet.getString(8));
                            vehicle = new Vehicle(id, make, model, price, fuelConsumption, power, year, fuelType);
                        }
                        log.info("Select one: Successful");
                    }
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return vehicle;
        }

    /**
     * Insert int.
     *
     * @param vehicle the vehicle
     * @return the int
     */
    public static int insert(Vehicle vehicle) {

            try{
                log.info("DB inserting routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "INSERT INTO vehicles (make, model, price, fuelConsumption, power, year, fuelType) Values (?, ?, ?, ?, ?, ?, ?)";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setString(1, vehicle.getMake());
                        preparedStatement.setString(2, vehicle.getModel());
                        preparedStatement.setDouble(3, vehicle.getPrice());
                        preparedStatement.setDouble(4, vehicle.getFuelConsumption());
                        preparedStatement.setInt(5, vehicle.getPower());
                        preparedStatement.setInt(6, vehicle.getYear());
                        preparedStatement.setString(7, vehicle.getFuelType().toString());

                        log.info("Insert: Successful");
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return 0;
        }

    /**
     * Update int.
     *
     * @param vehicle the vehicle
     * @return the int
     */
    public static int update(Vehicle vehicle) {

            try{
                log.info("DB updating routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "UPDATE vehicles SET make = ?, model = ?, price = ?, fuelConsumption = ?, power = ?, year = ?, fuelType = ? WHERE id = ?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setString(1, vehicle.getMake());
                        preparedStatement.setString(2, vehicle.getModel());
                        preparedStatement.setDouble(3, vehicle.getPrice());
                        preparedStatement.setDouble(4, vehicle.getFuelConsumption());
                        preparedStatement.setInt(5, vehicle.getPower());
                        preparedStatement.setInt(6, vehicle.getYear());
                        preparedStatement.setString(7, vehicle.getFuelType().toString());
                        preparedStatement.setInt(8, vehicle.getId());

                        log.info("Update: Successful");
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return 0;
        }

    /**
     * Delete int.
     *
     * @param id the id
     * @return the int
     */
    public static int delete(int id) {

            try{
                log.info("DB deleting routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "DELETE FROM vehicles WHERE id = ?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setInt(1, id);

                        log.info("Delete: Successful");
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return 0;
        }
}
