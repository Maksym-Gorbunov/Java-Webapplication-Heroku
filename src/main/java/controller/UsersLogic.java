package controller;

import model.beans.User;
import model.db.users.UsersDBHelper;

import java.util.List;

public class UsersLogic implements UsersLogicInterface {
  public static boolean loggedIn;
  public static UsersDBHelper dbHelper;
  public static List<User> users;
  public static User user;

  static {
    loggedIn = false;
    dbHelper = new UsersDBHelper();
    users = dbHelper.getAllUsers();
  }

  public static User userExist(String login, String password) {
    return dbHelper.exist(login, password);
  }

  public static void addUser(String login, String password) {
    dbHelper.add(login, password);
    String id = String.valueOf(users.size());
    User u = new User(id, login, password);
    users.add(u);
  }

  public static void deleteUser(User u){
    dbHelper.delete(u.getLogin(), u.getPassword());
    if(users.contains(u)){
      users.remove(u);
    }
  }

  public void editUser(User oldUser, User newUser){
    dbHelper.update(oldUser.getLogin(), oldUser.getPassword(), newUser.getLogin(), newUser.getPassword());
    for(User u: users){
      if(u.getLogin()==oldUser.getLogin() && u.getPassword()==oldUser.getPassword()){
        u.setLogin(newUser.getLogin());
        u.setPassword(newUser.getPassword());
      }
    }
  }
}
