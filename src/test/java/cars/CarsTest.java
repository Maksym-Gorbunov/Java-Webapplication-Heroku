package cars;

import model.CarsModel;
import model.beans.Car;
import model.db.CarsDBInterface;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

  CarsModel model;
  CarsDBInterface fakeDBHelper = new FakeCardDBHelper();

  @Before
  public void init(){
    model = new CarsModel(fakeDBHelper);
  }
}
