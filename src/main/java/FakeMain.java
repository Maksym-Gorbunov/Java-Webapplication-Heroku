import controller.servlet.Cars;
import model.beans.Car;
import model.db.cars.CarsDBHelper;
import model.db.cars.CarsDBInterface;

import java.util.ArrayList;
import java.util.List;

public class FakeMain {

  public static void main(String[] args) {
    CarsDBInterface db = new CarsDBHelper();
    List<Car> data = new ArrayList<>();
    data = db.selectAll();

    for(Car c:data){
      System.out.println("fakeData.add(new Car("
              +"\""+c.getMake() + "\", "
              +"\""+c.getColor() + "\", "
              +"\""+c.getLicensenumber()+"\"));");
    }
  }



}
