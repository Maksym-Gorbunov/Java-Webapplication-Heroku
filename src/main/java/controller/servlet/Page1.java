package controller.servlet;

import model.Model;

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
    if (!Model.loggedIn) {
      response.sendRedirect("login");
//      request.setAttribute("users", model.IModel.users);
//      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    } else {
      request.setAttribute("user", Model.user);
      request.setAttribute("users", Model.users);
      request.getRequestDispatcher("/pages/page1/page1.jsp").forward(request, response);
    }
  }
}
