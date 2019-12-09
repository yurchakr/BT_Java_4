package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.FuelType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * The type Add servlet.
 */
public class AddServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(AddServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/add.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            log.info("Adding routine started...");
            DaoFactory.getVehicleDAO().addVehicle(req.getParameter("make"), req.getParameter("model"),
                    Double.parseDouble(req.getParameter("price")), Double.parseDouble(req.getParameter("fuelConsumption")),
                    Integer.parseInt(req.getParameter("power")), Integer.parseInt(req.getParameter("year")),
                    FuelType.valueOf(req.getParameter("fuelType")));
            log.info("Add: Successful");
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            getServletContext().getRequestDispatcher("/views/add.jsp").forward(req, resp);
        }
    }
}
