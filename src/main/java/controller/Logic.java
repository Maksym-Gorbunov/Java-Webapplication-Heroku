package controller;

import model.beans.User;
import model.db.sqlite.DBHelper;

import java.util.List;

public class Logic {
  public static boolean loggedIn;
  public static DBHelper dbHelper;
  public static List<User> users;

  static {
    loggedIn = false;
    dbHelper = new DBHelper();
    users = dbHelper.getAllUsers();
  }

  public static boolean userExist(User user) {
    return dbHelper.exist(user);
  }
}
