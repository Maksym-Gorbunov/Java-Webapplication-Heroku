package controller;

import model.beans.Car;
import model.db.cars.CarsDBInterface;

import java.util.List;

public class CarsLogic {

  private CarsDBInterface db;

  public CarsLogic(CarsDBInterface db){
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
