import model.CarsModel;
import model.beans.Car;
import model.beans.User;
import model.db.UsersDBHelper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    CarsModel model = new CarsModel();
    List<Car> data = model.getAllCars();
    System.out.println(data);


//    Path root = Paths.get(".").normalize().toAbsolutePath();
//    String home = root.toString();
//    System.out.println("jjj "+home);
//
//
//    ClassLoader loader = Main.class.getClassLoader();
//    System.out.println("kkk "+loader.getResource("Main.class").getPath());
//
//
//    UsersDBHelper dbHelper = new UsersDBHelper();
//    List<User> users = dbHelper.getAllUsers();
////    List<Car> cars = dbHelper.selectAllCars();
//    System.out.println(users.size());
////    System.out.println(cars.size());
  }

}
