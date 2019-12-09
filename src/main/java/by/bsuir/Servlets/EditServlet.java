package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.FuelType;
import by.bsuir.autobase.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * The type Edit servlet.
 */
public class EditServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(EditServlet.class));

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
            log.info(ex.getMessage());
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            log.info("Editing routine started...");
            DaoFactory.getVehicleDAO().editVehicle(Integer.parseInt(req.getParameter("id")), req.getParameter("make"),
                    req.getParameter("model"), Double.parseDouble(req.getParameter("price")),
                    Double.parseDouble(req.getParameter("fuelConsumption")), Integer.parseInt(req.getParameter("power")),
                    Integer.parseInt(req.getParameter("year")), FuelType.valueOf(req.getParameter("fuelType")));
            log.info("Edit: Successful");
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
        }
    }
}
