package model.db;
import model.beans.Car;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface CarDBInterface {
  public List<Car> selectAll();

  public void insert(String make, String color, String licensenumber);

  public void update(String licensenumber, Car car);

  public void delete(String licensenumber);

  public Car exist(String licensenumber);
}
