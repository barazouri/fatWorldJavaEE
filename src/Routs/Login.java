package Routs;

import Entities.User;
import Logic.UserFunctionality;
import org.hibernate.HibernateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "login",
        urlPatterns = {"/Login"}
)public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Login() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            if (UserFunctionality.login(email, password)) {
                User userTmp = UserFunctionality.getUser(email);
                request.getSession().setAttribute("user", userTmp);
                Cookie cookie = new Cookie("email", email);
                cookie.setMaxAge(60 * 30); // half hour
                response.addCookie(cookie);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("validateUser", false);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error_page.jsp");
        }
    }

}
