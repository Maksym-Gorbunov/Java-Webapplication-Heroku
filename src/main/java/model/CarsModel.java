package model;

import model.beans.Car;
import model.db.CarDBInterface;
import model.db.CarsDBHelper;

import java.util.List;

public class CarsModel {

  private CarDBInterface db;

  public CarsModel(){
    db = new CarsDBHelper();
  }

  public List<Car> getAllCars(){
    return db.selectAll();
  }

  public void add(Car car){
    db.insert(car.getLicensenumber(), car.getColor(),car.getMake());
  }

  public void edit(Car car, Car newCar){
    db.update(car.getMake(),car.getColor(),car.getLicensenumber()
            ,newCar.getMake(),newCar.getColor(),newCar.getLicensenumber());
  }

  public void delete(Car car){
    db.delete(car.getLicensenumber());
  }
}
