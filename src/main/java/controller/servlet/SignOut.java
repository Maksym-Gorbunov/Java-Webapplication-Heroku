package controller.servlet;

import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signout")
public class SignOut extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UsersModel.loggedIn = false;
    UsersModel.user = null;
    response.sendRedirect("login");
//    request.setAttribute("users", controller.UsersLogicInterface.users);
//    request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
  }
}
