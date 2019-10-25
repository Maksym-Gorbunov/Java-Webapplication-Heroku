package model;

import model.beans.Car;
import model.db.CarsDBInterface;
import model.db.CarsDBHelper;

import java.util.List;

public class CarsModel {

  private CarsDBInterface db;

  public CarsModel(CarsDBInterface db){
    this.db = db;
  }

  public List<Car> getAllCars(){
    return db.selectAll();
  }

  public void add(Car car){
    db.insert(car);
  }

  public void edit(String licensenumber, Car newCar){
    db.update(licensenumber, newCar);
  }

  public void delete(String licensenumber){
    db.delete(licensenumber);
  }

  public Car exist(String licensenumber){
    return db.exist(licensenumber);
  }
}
