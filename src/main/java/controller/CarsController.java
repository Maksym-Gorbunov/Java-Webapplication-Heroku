package controller;

import model.CarsModel;
import model.beans.Car;
import model.db.CarDBInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cars")
public class CarsController extends HttpServlet {

  private CarsModel model = new CarsModel();

  // DELETE
  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Delete");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("cars Delete");
  }

  // UPDATE
  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Update");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("cars Update" + request.getParameter("make"));
  }

  // POST
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String method = request.getParameter("_method");
    System.out.println(method+" -------------");
    switch (method) {
      case "PUT":
        doPut(request, response);
        break;
      case "DELETE":
        doDelete(request, response);
        break;
      default:
        String make = request.getParameter("make");
        String color = request.getParameter("color");
        String licensenumber = request.getParameter("licensenumber");
        Car car = new Car(make, color, licensenumber);
        model.add(car);
        response.sendRedirect("cars");
    }
  }

  // GET
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Car> cars = model.getAllCars();
    request.setAttribute("cars", cars);
    request.getRequestDispatcher("/pages/cars/cars.jsp").forward(request, response);
  }
}
