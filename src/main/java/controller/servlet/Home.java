package controller.servlet;

import model.UsersModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class Home extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("HOME");
    //UsersModel.user = UsersModel.dbHelper.getAllUsers().get(3);
    //UsersModel.loggedIn = true;

    if (!UsersModel.loggedIn) {
      response.sendRedirect("login");
    } else {
      request.setAttribute("pageName", "home");
      request.setAttribute("user", UsersModel.user);
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }
}
