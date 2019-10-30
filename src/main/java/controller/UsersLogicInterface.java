package controller;

import model.beans.User;
import model.db.users.UserDBInterface;

import java.util.List;

public interface UsersLogicInterface {
  public static boolean loggedIn = false;
  public static UserDBInterface dbHelper = null;
  public static List<User> users = null;
  public static User user = null;

  public static User userExist(String login, String password){
    return null;
  };
  public static void addUser(){}
  public static void deleteUser(){}
  public static void editUser(){}
}
