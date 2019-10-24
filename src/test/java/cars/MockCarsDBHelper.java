package cars;

import model.beans.Car;
import model.db.CarsDBInterface;

import java.util.List;

public class MockCarsDBHelper implements CarsDBInterface {


  @Override
  public List<Car> selectAll() {
    return null;
  }

  @Override
  public void insert(String make, String color, String licensenumber) {

  }

  @Override
  public void update(String licensenumber, Car car) {

  }

  @Override
  public void delete(String licensenumber) {

  }

  @Override
  public Car exist(String licensenumber) {
    return null;
  }
}
