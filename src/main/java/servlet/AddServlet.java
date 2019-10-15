package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pages/page1")
public class AddServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Object data = "Some data, can be a String or a Javabean";
    request.setAttribute("data", data);
    request.getRequestDispatcher("/pages/page1.jsp").forward(request, response);
    //response.sendRedirect("index.");
    //PrintWriter pw = response.getWriter();
    //pw.print("AddServlet");
  }
}
