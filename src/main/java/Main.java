import model.beans.Car;
import model.beans.User;
import model.db.sqlite.DBHelper;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    DBHelper dbHelper = new DBHelper();
    List<User> users = dbHelper.getAll();
//    List<Car> cars = dbHelper.selectAllCars();
    System.out.println(users.size());
//    System.out.println(cars.size());
  }

}
