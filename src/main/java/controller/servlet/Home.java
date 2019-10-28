package controller.servlet;

import controller.UsersLogic;

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
    //UsersLogic.user = UsersLogic.dbHelper.getAllUsers().get(3);
    //UsersLogic.loggedIn = true;



    if (!UsersLogic.loggedIn) {
      response.sendRedirect("login");
    } else {
      request.setAttribute("pageName", "home");
      request.setAttribute("user", UsersLogic.user);
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }
}
