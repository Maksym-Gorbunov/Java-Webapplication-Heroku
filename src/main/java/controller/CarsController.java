package controller;

import model.CarsModel;
import model.beans.Car;
import model.db.CarDBInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cars")
public class CarsController extends HttpServlet {

  private CarsModel model = new CarsModel();

  // DELETE
  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String make = request.getParameter("make");
//    String color = request.getParameter("color");
//    String licensenumber = request.getParameter("licensenumber");
//    Car car = new Car(make, color, licensenumber);
//    System.out.println(car);
//    System.out.println("before " + model.getAllCars().size());
//    model.delete(car);
//    System.out.println("after " + model.getAllCars().size());
////    response.sendRedirect("/");
    System.out.println("--del Servlet--");
//    response.sendRedirect("pages/page1");
//    System.out.println("--del Servlet after--");
////    doGet(request, response);
////    List<Car> cars = new ArrayList<>();
////    cars = model.getAllCars();
////    cars.clear();
////    request.setAttribute("cars", cars);
////
//    //request.getRequestDispatcher("/pages/cars/cars.jsp").forward(request, response);

  }

  // UPDATE
  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String licensenumber = request.getParameter("licensenumber");
    String newMake = request.getParameter("newMake");
    String newColor = request.getParameter("newColor");
    String newLicensenumber = request.getParameter("newLicensenumber");
    Car newCar = new Car(newMake, newColor, newLicensenumber);
    model.edit(licensenumber, newCar);
  }

  // POST
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String _method = request.getParameter("_method");
    System.out.println("_method: "+ _method);
    switch (_method) {
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
