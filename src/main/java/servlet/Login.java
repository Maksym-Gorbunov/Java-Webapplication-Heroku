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
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!Logic.loggedIn) {
      String login = request.getParameter("username");
      String password = request.getParameter("pass");
      if ((login != null && !login.equals("")) && (password != null && !password.equals(""))) {
        User user = new User(login, password);
        if (Logic.userExist(user)) {
          Logic.loggedIn = true;
          Logic.user = user;
          request.setAttribute("user", user.getLogin());
          request.getRequestDispatcher("/pages/page1/page1.jsp").forward(request, response);
        } else {
          String message = "Login or password invalid! Try again.";
          request.setAttribute("message", message);
          request.setAttribute("users", Logic.users);
          request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
      } else {
        String message = "Back-end error, sqlite return NULL";
        request.setAttribute("message", message);
        request.setAttribute("users", Logic.users);
        request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
      }
    } else {
      request.setAttribute("user", Logic.user);
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (!Logic.loggedIn) {
      request.setAttribute("users", Logic.users);
      request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
    } else {
      request.setAttribute("user", Logic.user.getLogin());
      request.setAttribute("users", Logic.users);
      request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
  }
}
