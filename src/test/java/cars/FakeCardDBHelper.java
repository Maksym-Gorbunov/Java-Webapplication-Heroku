package cars;

import model.beans.Car;
import model.db.CarsDBInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FakeCardDBHelper implements CarsDBInterface {

  public static void main(String[] args) {
    FakeCardDBHelper f = new FakeCardDBHelper();

    f.fakeData.forEach(System.out::println);
    System.out.println();

    f.delete("AAA111");

    f.fakeData.forEach(System.out::println);
    System.out.println();

    f.update("BBB222", new Car("Smart", "Golden", "sds"));
    f.fakeData.forEach(System.out::println);
    System.out.println();

    f.fakeData.add(null);

    f.fakeData.forEach(System.out::println);
    System.out.println();


  }


  private List<Car> fakeData = new ArrayList<>();

  public FakeCardDBHelper() {
    fakeData.add(new Car("Ford", "green", "AAA111"));
    fakeData.add(new Car("Audi", "red", "BBB222"));
    fakeData.add(new Car("Honda", "blue", "CCC333"));
    fakeData.add(new Car("Volvo", "white", "DDD444"));
  }

  @Override
  public List<Car> selectAll() {
    if (fakeData != null) {
      return fakeData;
    }
    return null;
  }

  @Override
  public void insert(Car car) {
    if (car != null) {
      fakeData.add(car);
    }
  }

  @Override
  public void update(String licensenumber, Car car) {
    for (Car c : fakeData) {
      if (c.getLicensenumber().equals(licensenumber)) {
        c.setMake(car.getMake());
        c.setColor(car.getColor());
      }
    }
  }

  @Override
  public void delete(String licensenumber) {
    fakeData.removeIf(car -> car.getLicensenumber() == licensenumber);
  }

  @Override
  public Car exist(String licensenumber) {
    for (Car c : fakeData) {
      if (c.getLicensenumber().equals(licensenumber)) {
        return c;
      }
    }
    return null;
  }
}
