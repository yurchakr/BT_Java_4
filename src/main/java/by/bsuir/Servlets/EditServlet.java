package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Edit servlet.
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Vehicle vehicle = DaoFactory.getVehicleDAO().getVehicle(id);
            if(vehicle != null) {
                req.setAttribute("vehicle", vehicle);
                getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
            }
            else {
                resp.sendRedirect(req.getContextPath()+"/vehicles");
            }
        }
        catch(Exception ex) {
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DaoFactory.getVehicleDAO().editVehicle(Integer.parseInt(req.getParameter("id")), req.getParameter("make"),
                    req.getParameter("model"), Double.parseDouble(req.getParameter("price")),
                    Double.parseDouble(req.getParameter("fuelConsumption")), Integer.parseInt(req.getParameter("power")),
                    Integer.parseInt(req.getParameter("year")), FuelType.valueOf(req.getParameter("fuelType")));
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
        catch(Exception ex) {
            System.out.println(ex);
            getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
        }
    }
}
