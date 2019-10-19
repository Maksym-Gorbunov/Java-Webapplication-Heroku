package servlet;

import controller.Logic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class Home extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    /*
    if(!Logic.loggedIn){
      response.sendRedirect("login");
    } else {
      request.setAttribute("user", Logic.user.getLogin());
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    */
    Logic.user = Logic.dbHelper.getAllUsers().get(2);
    Logic.loggedIn = true;
    //response.sendRedirect("pages/page1");
    request.setAttribute("user", Logic.user.getLogin());
    request.getRequestDispatcher("/index.jsp").forward(request, response);


  }
}
