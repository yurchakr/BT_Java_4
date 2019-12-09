package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Delete servlet.
 */
public class DeleteServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(DeleteServlet.class));

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        try {
            log.info("Editing routine started...");
            DaoFactory.getVehicleDAO().deleteVehicle(Integer.parseInt(request.getParameter("id")));
            log.info("Edit: Successful");
            response.sendRedirect(request.getContextPath() + "/vehicles");
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            response.sendRedirect(request.getContextPath() + "/vehicles");
        }
    }
}
