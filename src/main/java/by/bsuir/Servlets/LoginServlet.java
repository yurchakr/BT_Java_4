package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Login servlet.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = DaoFactory.getUserDAO().getUser(req.getParameter("name"), req.getParameter("password"));
            if(user != null) {
                resp.sendRedirect(req.getContextPath()+"/vehicles");
            }
            else {
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }
        catch(Exception ex) {
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}
