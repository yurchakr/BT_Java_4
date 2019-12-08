package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        try {
            DaoFactory.getVehicleDAO().deleteVehicle(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath() + "/vehicles");
        }
        catch(Exception ex) {
            response.sendRedirect(request.getContextPath() + "/vehicles");
        }
    }
}
