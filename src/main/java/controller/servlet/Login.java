package controller.servlet;

import controller.UsersLogic;
import model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

  private List<User> data = new ArrayList<>();

  public Login(){
    data.add(UsersLogic.users.get(0));
    data.add(UsersLogic.users.get(1));
    data.add(UsersLogic.users.get(3));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!UsersLogic.loggedIn) {
      String login = request.getParameter("username");
      String password = request.getParameter("pass");
      if ((login != null && !login.equals("")) && (password != null && !password.equals(""))) {
        User user = UsersLogic.userExist(login, password);
        if (user != null) {
          UsersLogic.loggedIn = true;
          UsersLogic.user = user;
          response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else {
          String message = "Login or password invalid! Try again.";
          request.setAttribute("message", message);
          request.setAttribute("data", data);
          request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
      } else {
        String message = "Back-end error, sqlite return NULL";
        request.setAttribute("message", message);
        request.setAttribute("data", data);
        request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
      }
    } else {
      response.sendRedirect("login");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!UsersLogic.loggedIn) {
      request.setAttribute("data", data);
      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    } else {
      request.setAttribute("pageName", "home");
      request.setAttribute("user", UsersLogic.user.getLogin());
      request.setAttribute("users", UsersLogic.users);
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }
}
