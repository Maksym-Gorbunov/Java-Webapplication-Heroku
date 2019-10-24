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
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    /*
    if(!model.UsersModelInterface.loggedIn){
      response.sendRedirect("login");
    } else {
      request.setAttribute("user", model.UsersModelInterface.user.getLogin());
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    */
    UsersModel.user = UsersModel.dbHelper.getAllUsers().get(3);
    UsersModel.loggedIn = true;
    //response.sendRedirect("pages/page1");
    request.setAttribute("user", UsersModel.user);
    request.getRequestDispatcher("/index.jsp").forward(request, response);


  }
}
