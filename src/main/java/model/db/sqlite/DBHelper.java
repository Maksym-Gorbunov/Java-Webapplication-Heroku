package model.db.sqlite;

/*
id          login       password
----------  ----------  ----------
1           user1       password1
2           user2       password2
3           user3       password3
4           admin       password
*/

import model.beans.User;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {


  public DBHelper(){
    if (!DriverManager.getDrivers().hasMoreElements()) {
      try {
        Class.forName("org.sqlite.JDBC").newInstance();
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  public Connection connect() {
    String projectUrl = "http://localhost:8088/mg_webapplication_Web_exploded";
//    String dbPath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "cars.db";
//    String dbPath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "users.db";
    //String dbPath = System.getProperty("user.dir")+ File.separator + "web" + File.separator + "data" + File.separator + "users.db";
    String dbPath = "C:\\java\\mg-webapplication\\out\\artifacts\\mg_webapplication_Web_exploded\\data\\users.db";
    String url = "jdbc:sqlite:" + dbPath;
    System.out.println(">>>   "+url);
    System.out.println(">>>   "+url);
    Connection conn = null;
    try {

      conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }





  public List<User> getAll(){
    //String sql = "SELECT login, password FROM users";
    String sql = "SELECT login, password FROM users";
    List<User> users = new ArrayList<>();
    try (
            Connection conn = this.connect();
         Statement stmt  = conn.createStatement();
         ResultSet rs    = stmt.executeQuery(sql)){
      while (rs.next()) {
        User user = new User(rs.getString("login"),
                rs.getString("password"));
        users.add(user);
      }
      return users;
    } catch (SQLException e) {
      System.out.println("-->" + e.getMessage());
    }
    return null;
  }


  /*
  public void add(String login, String password) {
    String sql = "INSERT INTO users(login, password) VALUES(?,?)";
    try (Connection connection = this.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, login);
      pstmt.setString(2, password);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }


  public void update(String login, String password, String newLogin, String newPassword) {
    String sql = "UPDATE users set login=?, password=? WHERE login=? AND password=?";
    try (Connection connection = this.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, newLogin);
      pstmt.setString(2, newPassword);
      pstmt.setString(3, login);
      pstmt.setString(4, password);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(String login, String password){
    String sql = "DELETE FROM users WHERE login=? AND password=?";
    try (Connection connection = this.connect();
         PreparedStatement pstmt = connection.prepareStatement(sql)){
      pstmt.setString(1, login);
      pstmt.setString(2, password);
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  */
}
