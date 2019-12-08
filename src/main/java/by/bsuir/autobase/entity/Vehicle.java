package by.bsuir.autobase.entity;

public class Vehicle {

    private int id;
    private String make;
    private String model;
    private double price;
    private double fuelConsumption;
    private int power;
    private int year;
    private FuelType fuelType;

    public Vehicle(int id, String _make, String _model, double _price, double _fuelConsumption,
                   int _power, int _year, FuelType _fuelType){
        this.id = id;
        make = _make;
        model = _model;
        price = _price;
        fuelConsumption =_fuelConsumption;
        power = _power;
        year = _year;
        fuelType = _fuelType;
    }

    public Vehicle(String _make, String _model, double _price, double _fuelConsumption,
                   int _power, int _year, FuelType _fuelType){
        make = _make;
        model = _model;
        price = _price;
        fuelConsumption =_fuelConsumption;
        power = _power;
        year = _year;
        fuelType = _fuelType;
    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }



}