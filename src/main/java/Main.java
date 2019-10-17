import model.beans.Car;
import model.beans.User;
import model.db.sqlite.DBHelper;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class Main {
  public static void main(String[] args) {
    Path root = Paths.get(".").normalize().toAbsolutePath();
    String home = root.toString();
    System.out.println("jjj "+home);


    ClassLoader loader = Main.class.getClassLoader();
    System.out.println("kkk "+loader.getResource("Main.class").getPath());


    DBHelper dbHelper = new DBHelper();
    List<User> users = dbHelper.getAll();
//    List<Car> cars = dbHelper.selectAllCars();
    System.out.println(users.size());
//    System.out.println(cars.size());
  }

}
