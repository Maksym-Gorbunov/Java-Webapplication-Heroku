package controller.servlet;

import model.CarsModel;
import model.beans.Car;
import model.db.cars.CarsDBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class Cars extends HttpServlet {

  private CarsModel model = new CarsModel(new CarsDBHelper());

  // DELETE
  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String licensenumber = request.getParameter("licensenumber");
    model.delete(licensenumber);
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
    request.setAttribute("pageName", "cars");
    request.setAttribute("cars", cars);
    request.getRequestDispatcher("/pages/cars/cars.jsp").forward(request, response);
  }
}
