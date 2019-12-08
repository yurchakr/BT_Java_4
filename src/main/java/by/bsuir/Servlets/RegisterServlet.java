package by.bsuir.Servlets;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Register servlet.
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = DaoFactory.getUserDAO().getUserByName(req.getParameter("name"));
            if(user != null) {
                req.setAttribute("message", "This name already exists");
                getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
            }
            else {
                DaoFactory.getUserDAO().addUser(req.getParameter("name"), req.getParameter("password"));
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }
        catch(Exception ex) {
            req.setAttribute("message", "Error");
            getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}
