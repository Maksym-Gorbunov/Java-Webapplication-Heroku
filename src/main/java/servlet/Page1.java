package servlet;

import controller.Logic;
import model.beans.User;
import model.db.sqlite.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/pages/page1")
public class Page1 extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!Logic.loggedIn) {
      response.sendRedirect("login");
//      request.setAttribute("users", Logic.users);
//      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    } else {
      request.setAttribute("user", Logic.user);
      request.setAttribute("users", Logic.users);
      request.getRequestDispatcher("/pages/page1/page1.jsp").forward(request, response);
    }
  }
}
