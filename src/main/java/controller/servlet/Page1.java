package controller.servlet;

import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pages/page1")
public class Page1 extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!UsersModel.loggedIn) {
      response.sendRedirect("login");
//      request.setAttribute("users", model.UsersModelInterface.users);
//      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    } else {
      request.setAttribute("user", UsersModel.user);
      request.setAttribute("users", UsersModel.users);
      request.getRequestDispatcher("/pages/page1/page1.jsp").forward(request, response);
    }
  }
}
