package cars;

import model.CarsModel;
import model.beans.Car;
import model.db.CarsDBInterface;
import model.db.CarsDBHelper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;


public class MockTest {

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
    // Mock logic
    when(mockDB.selectAll()).thenReturn(data);

  }

  @Test
  public void getAllCarsTest(){
    List<Car> expectedData = new ArrayList<>();
    expectedData.add(new Car("Ford", "green", "AAA111"));
    expectedData.add(new Car("Audi", "red", "BBB222"));
    expectedData.add(new Car("Honda", "blue", "CCC333"));
    expectedData.add(new Car("Volvo", "white", "DDD444"));
    assertEquals(expectedData, model.getAllCars());
    verify(mockDB).selectAll();
  }

  @Test
  public void updateTest(){
    String licensenumber = "AAA111";
    when(mockDB.update())
  }
}
