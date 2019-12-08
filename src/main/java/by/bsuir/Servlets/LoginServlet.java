package by.bsuir.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/login.html").forward(req, resp);

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
