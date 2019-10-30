package controller.servlet;

import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// ABOUT  PAGE
@WebServlet("/about")
public class About extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!UsersModel.loggedIn) {
      response.sendRedirect("login");
    } else {
      request.setAttribute("pageName", "about");
      request.setAttribute("user", UsersModel.user);
      request.getRequestDispatcher("/pages/about/about.jsp").forward(request, response);
    }
  }
}
