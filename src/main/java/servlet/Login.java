package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

  public static boolean loggedIn = false;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("pass");
    System.out.println(username);
    if ((username != null && !username.equals("")) && (password != null && !password.equals(""))) {
      PrintWriter pw = response.getWriter();
      pw.println("User: " + username);
      pw.println("Password: " + password);
      if(username.equals("admin")){
        //response.sendRedirect("../../pages/page1");
        request.getRequestDispatcher("/pages/page1/page1.jsp").forward(request, response);
      }
    } else {
      PrintWriter pw = response.getWriter();
      pw.println("Error");
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Object data = "login status";
    request.setAttribute("data", data);
    request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
  }
}
