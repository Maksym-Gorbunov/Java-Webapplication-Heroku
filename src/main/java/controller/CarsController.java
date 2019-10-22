package controller;

import model.CarsModel;
import model.beans.Car;
import model.db.CarDBInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet(name = "CarsController")
@WebServlet("/cars")
public class CarsController extends HttpServlet {

  private CarsModel model = new CarsModel();

  // POST
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String make = request.getParameter("make");
    String color = request.getParameter("color");
    String licensenumber = request.getParameter("licensenumber");
    Car car = new Car(make, color, licensenumber);
    model.add(car);
    response.sendRedirect("cars");
  }

  // GET
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Car> cars = model.getAllCars();
    request.setAttribute("cars", cars);
    request.getRequestDispatcher("/pages/cars/cars.jsp").forward(request, response);
  }

}
