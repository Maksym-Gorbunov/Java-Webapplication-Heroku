package controller.servlet;

import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/pages/users")
@WebServlet("/users")
public class Users extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!UsersModel.loggedIn) {
      response.sendRedirect("login");
//      request.setAttribute("users", controller.UsersLogicInterface.users);
//      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    } else {
      request.setAttribute("pageName", "users");
      request.setAttribute("user", UsersModel.user);
      request.setAttribute("users", UsersModel.users);
      request.getRequestDispatcher("/pages/users/users.jsp").forward(request, response);
    }
  }
}
