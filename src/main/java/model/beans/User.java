package model.beans;

import javafx.beans.property.SimpleStringProperty;

public class User {

  private String login;
  private String password;
  public static final long serialVersionUID = 11L;


  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return login.equals(user.login);
  }

  @Override
  public int hashCode() {
    return login.hashCode();
  }
}
