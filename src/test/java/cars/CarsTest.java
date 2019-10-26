package cars;

import model.CarsModel;
import model.beans.Car;
import model.db.CarsDBInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarsTest {

  CarsModel model;
  CarsDBInterface fakeDBHelper = new FakeCardDBHelper();

  @Before
  public void init(){
    model = new CarsModel(fakeDBHelper);
  }

  @Test
  public void add(){
    Car car = new Car("Tesla", "black", "TTT123");
    assertEquals(false, model.getAllCars().contains(car));
    model.add(car);
    assertEquals(true, model.getAllCars().contains(car));
  }


}
