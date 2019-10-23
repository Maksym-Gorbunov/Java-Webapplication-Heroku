package model.db;

import model.beans.Car;
import model.beans.User;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TABLE cars (
// make TEXT,
// color TEXT,
// licensenumber TEXT PRIMARY KEY);

public class CarsDBHelper implements CarDBInterface {

  private Connection connect() {
//    String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "cars.db";
    String path = "C:\\java\\mg-webapplication\\out\\artifacts\\mg_webapplication_Web_exploded\\data\\cars.db";
    String url = "jdbc:sqlite:" + path;
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public List<Car> selectAll(){
    String sql = "SELECT make, color, licensenumber FROM cars";
    List<Car> cars = new ArrayList<>();
    try (Connection conn = this.connect();
         Statement stmt  = conn.createStatement();
         ResultSet rs    = stmt.executeQuery(sql)){
      while (rs.next()) {
        Car car = new Car(rs.getString("make"),
                rs.getString("color"),
                rs.getString("licensenumber"));
        cars.add(car);
      }
      return cars;
    } catch (SQLException e) {
      System.out.println("-->" + e.getMessage());
    }
    return null;
  }

  public void insert(String make, String color, String licensenumber) {
    String sql = "INSERT INTO cars(make, color, licensenumber) VALUES(?,?,?)";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, make);
      pstmt.setString(2, color);
      pstmt.setString(3, licensenumber);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }


  public void update(String licensenumber, Car car) {
    System.out.println("1111");
    String sql = "UPDATE cars set make=?, color=? WHERE licensenumber=?";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, car.getMake());
      pstmt.setString(2, car.getColor());
      pstmt.setString(3, licensenumber);
      pstmt.executeUpdate();
      System.out.println("db.updated");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(String licensenumber){
    String sql = "DELETE FROM cars WHERE licensenumber=?";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)){
      pstmt.setString(1, licensenumber);
      pstmt.executeUpdate();
      System.out.println("deleted");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Car exist(String licensenumber) {
    String sql = "SELECT make, color, licensenumber FROM cars WHERE licensenumber=?";
    try (
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, licensenumber);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        Car car = new Car(rs.getString("make"),
                rs.getString("color"),
                rs.getString("licensenumber"));
        return car;
      }
    } catch (SQLException e) {
      System.out.println("-->" + e.getMessage());
    }
    return null;
  }
}
