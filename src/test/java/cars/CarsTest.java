package cars;

import controller.CarsLogic;
import model.beans.Car;
import model.db.cars.CarsDBInterface;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CarsTest {

  CarsLogic model;
  CarsDBInterface fakeDBHelper = new FakeCardDBHelper();

  @Before
  public void init(){
    model = new CarsLogic(fakeDBHelper);
  }

  @Test
  public void addTest(){
    Car car = new Car("Tesla", "black", "TTT123");
    assertEquals(false, model.getAllCars().contains(car));
    model.add(car);
    assertEquals(true, model.getAllCars().contains(car));
  }

  @Test
  public void getAllTest(){
    List<Car> expected = new ArrayList<>();
    expected.add(new Car("Ford", "green", "AAA111"));
    expected.add(new Car("Audi", "red", "BBB222"));
    expected.add(new Car("Honda", "blue", "CCC333"));
    expected.add(new Car("Volvo", "white", "DDD444"));
    List<Car> actual = model.getAllCars();
    assertEquals(expected, actual);
  }

  @Test
  public void existTest(){
    Car car1 = new Car("Ford", "green", "AAA111");
    Car car2 = new Car("Honda", "silver", "XXX888");
    assertEquals(car1, model.exist(car1.getLicensenumber()));
    assertEquals(null, model.exist(car2.getLicensenumber()));
  }

  @Test
  public void editTest(){
    Car car = new Car("Honda", "blue", "CCC333");
    Car newCar = new Car("Mazda", "white", "CCC333");
    model.edit(car.getLicensenumber(), newCar);
    assertEquals(newCar, model.exist(newCar.getLicensenumber()));
  }

  @Test
  public void deleteTest(){
    Car car = new Car("Audi", "red", "BBB222");
    assertEquals(car, model.exist(car.getLicensenumber()));
    model.delete(car.getLicensenumber());
    assertEquals(null, model.exist(car.getLicensenumber()));

  }
}
