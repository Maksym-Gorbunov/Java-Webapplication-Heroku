package users;

import model.UsersModelInterface;
import model.UsersModel;
import model.beans.User;
import model.db.UserDBInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class MockitoTest {
  private UsersModelInterface fakeModel = new FakeModel();
  private UserDBInterface mockitoDBHelper = mock(UserDBInterface.class);
  private List<User> data = new ArrayList<>();

  //Test with fake UsersModel, without Mockito
//  @Test
//  public void getAllUsers(){
//    List<User> expected = new ArrayList<>();
//    expected.add(new User("1","FakeLogin1", "FakePassword1"));
//    expected.add(new User("2","FakeLogin2", "FakePassword1"));
//    expected.add(new User("3","FakeLogin3", "FakePassword3"));
//    expected.add(new User("4","FakeLogin4", "FakePassword4"));
//
//    List<User> actual = fakeModel.dbHelper.getAllUsers();
//    assertEquals(expected, actual);
//  }

  @Before
  public void init(){
    data.add(new User("1","FakeLogin1", "FakePassword1"));
    data.add(new User("2","FakeLogin2", "FakePassword1"));
    data.add(new User("3","FakeLogin3", "FakePassword3"));
    data.add(new User("4","FakeLogin4", "FakePassword4"));

  }


  @Test
  public void getAllUsersMockitoDBHelper(){
    when(mockitoDBHelper.getAllUsers()).thenReturn(data);
    assertEquals(data, mockitoDBHelper.getAllUsers());
    verify(mockitoDBHelper).getAllUsers();
  }

  @Test
  public void getAllUsersModel(){
    UsersModel.users = mockitoDBHelper.getAllUsers();
    List<User> expected = UsersModel.users;
    List<User> actual = data;
    assertEquals(expected, actual);
  }





//  @Test
//  public void addUser(){
//    int expected = fakeModel.users.size()+1;
//    //fakeModel.add .addUser();
//  }
}
