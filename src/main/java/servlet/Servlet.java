package servlet;

import controller.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class Servlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Logic logic = new Logic();
    if(Logic.loggedIn == false){
      request.setAttribute("users", Logic.users);
      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
      //response.sendRedirect("index.");
    } else {
      request.setAttribute("user", Logic.user.getLogin());
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }
}
