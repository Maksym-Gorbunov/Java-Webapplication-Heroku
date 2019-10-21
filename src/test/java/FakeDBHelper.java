/*
id          login       password
----------  ----------  ----------
1           user1       password1
2           user2       password2
3           user3       password3
4           admin       password
*/

import model.beans.User;
import model.db.sqlite.IDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FakeDBHelper implements IDB{

  private List<User> fakeUsers = new ArrayList<>();

  public FakeDBHelper(){
    fakeUsers.add(new User("1","FakeLogin1", "FakePassword1"));
    fakeUsers.add(new User("2","FakeLogin2", "FakePassword1"));
    fakeUsers.add(new User("3","FakeLogin3", "FakePassword3"));
    fakeUsers.add(new User("4","FakeLogin4", "FakePassword4"));
  }

  public Connection connect() {
    return null;
  }


  public List<User> getAllUsers() {
    return fakeUsers;
  }

  public void add(String login, String password) {
    fakeUsers.add(new User(String.valueOf(fakeUsers.size()+1), login, password));
  }


  public void update(String login, String password, String newLogin, String newPassword) {
    for(User u: fakeUsers){
      if(u.getLogin()==login && u.getPassword()==password){
        u.setLogin(newLogin);
        u.setPassword(newPassword);
      }
    }
  }

  public void delete(String login, String password) {
    fakeUsers.stream()
            .filter(user -> (user.getLogin()==login)&&(user.getPassword()==password))
            .map(user->fakeUsers.remove(user));
  }

  public User exist(String login, String password) {
    for(User u: fakeUsers){
      if(u.getLogin()==login && u.getPassword()==password){
        return u;
      }
    }
    return null;
  }

}
