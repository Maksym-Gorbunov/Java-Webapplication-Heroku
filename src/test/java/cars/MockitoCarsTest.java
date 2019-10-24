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

  CarsDBHelper mockDB = mock(CarsDBHelper.class);
  List<Car> data;
  CarsModel model;

  @Before
  public void init(){
    model = new CarsModel(mockDB);
    // Test DATA
    data = new ArrayList<>();
    data.add(new Car("Ford", "green", "AAA111"));
    data.add(new Car("Audi", "red", "BBB222"));
    data.add(new Car("Honda", "blue", "CCC333"));
    data.add(new Car("Volvo", "white", "DDD444"));
  }

  @Test
  public void getAllCarsTest(){
    when(mockDB.selectAll()).thenReturn(data);
    List<Car> expectedData = new ArrayList<>();
    expectedData.add(new Car("Ford", "green", "AAA111"));
    expectedData.add(new Car("Audi", "red", "BBB222"));
    expectedData.add(new Car("Honda", "blue", "CCC333"));
    expectedData.add(new Car("Volvo", "white", "DDD444"));
    List<Car> actual = model.getAllCars();
    assertEquals(expectedData, actual);
    verify(mockDB).selectAll();
  }

  @Test
  public void updateTest(){
    String licensenumber = "AAA111";
    Car car = new Car("Audi", "green", "AAA111");
    doNothing().when(mockDB).update(licensenumber ,car);
    //doNothing().when(mockDB).update(anyString() ,any(Car.class) );
    model.edit(licensenumber, car);
    verify(mockDB).update(licensenumber, car);
  }

  @Test
  public void existTest(){
    String licensenumber = "AAA111";
    String licensenumberWrong = "AAA999";
    Car car = new Car("Audi", "green", "AAA111");
    when(mockDB.exist(licensenumber)).thenReturn(car);
    when(mockDB.exist(licensenumberWrong)).thenReturn(null);
    Car actual = model.exist(licensenumber);
    Car actualWrong = model.exist(licensenumberWrong);
    assertEquals(car, actual);
    assertEquals(null, actualWrong);
    verify(mockDB).exist(licensenumber);
  }

  @Test
  public void deleteTest(){
    String licensenumber = "AAA111";
    doNothing().when(mockDB).delete(licensenumber);
    model.delete(licensenumber);
    verify(mockDB).delete(licensenumber);
  }
}
