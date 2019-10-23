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
    db.insert(car.getMake(), car.getColor(),car.getLicensenumber());
  }

  public void edit(String licensenumber, Car newCar){
    db.update(licensenumber, newCar);
  }

  public void delete(Car car){
    db.delete(car.getLicensenumber());
  }

  public Car exist(String licensenumber){
    return db.exist(licensenumber);
  }
}
