package Routs;
import Logic.UserFunctionality;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        name = "Register",
        urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Register() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String userName = request.getParameter("name");
            String password = request.getParameter("password");
            if (UserFunctionality.register(userName,email,password)) {
                Cookie cookie = new Cookie("UserName", email);
                cookie.setMaxAge(60 * 30);
                response.addCookie(cookie);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("Login", false);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            response.sendRedirect("error_page.jsp");
        }

    }
}
