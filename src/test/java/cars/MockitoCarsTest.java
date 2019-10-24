package cars;

import model.CarsModel;
import model.beans.Car;
import model.db.CarsDBHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;


public class MockitoCarsTest {

  CarsDBHelper service = mock(CarsDBHelper.class);
  List<Car> data;
  CarsModel model;

  @Before
  public void init() {
    model = new CarsModel(service);
    // Test DATA
    data = new ArrayList<>();
    data.add(new Car("Ford", "green", "AAA111"));
    data.add(new Car("Audi", "red", "BBB222"));
    data.add(new Car("Honda", "blue", "CCC333"));
    data.add(new Car("Volvo", "white", "DDD444"));
  }


  @Test
  public void getAllCarsTest() {
    when(service.selectAll()).thenReturn(data);
    List<Car> expectedData = new ArrayList<>();
    expectedData = data;
    List<Car> actual = model.getAllCars();
    assertEquals(expectedData, actual);
    verify(service).selectAll();
  }

  @Test
  public void addTest() {
    Car car = new Car("Saab", "yellow", "TTT777");
    doNothing().when(service).insert(car);
    model.add(car);
    verify(service).insert(car);
  }

  @Test
  public void updateTest() {
    String licensenumber = "AAA111";
    Car car = new Car("Audi", "green", "AAA111");
    doNothing().when(service).update(licensenumber, car);
    //doNothing().when(service).update(anyString() ,any(Car.class) );
    model.edit(licensenumber, car);
    verify(service).update(licensenumber, car);
  }

  @Test
  public void existTest() {
    String licensenumber = "AAA111";
    String licensenumberWrong = "AAA999";
    Car car = new Car("Audi", "green", "AAA111");
    when(service.exist(licensenumber)).thenReturn(car);
    when(service.exist(licensenumberWrong)).thenReturn(null);
    Car actual = model.exist(licensenumber);
    Car actualWrong = model.exist(licensenumberWrong);
    assertEquals(car, actual);
    assertEquals(null, actualWrong);
    verify(service).exist(licensenumber);
  }

  @Test
  public void deleteTest() {
    String licensenumber = "AAA111";
    doNothing().when(service).delete(licensenumber);
    model.delete(licensenumber);
    verify(service).delete(licensenumber);
  }
}
