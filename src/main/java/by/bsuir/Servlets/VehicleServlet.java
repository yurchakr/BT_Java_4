package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Logger;

public class VehicleServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(String.valueOf(VehicleServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        req.setAttribute("vehicleList", vehicles);

        getServletContext().getRequestDispatcher("/views/vehicle.jsp").forward(req, resp);

    }
}
