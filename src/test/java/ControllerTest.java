import static org.junit.Assert.*;

import java.io.*;
import javax.servlet.http.*;
//import org.apache.commons.io.FileUtils;
import controller.servlet.CarsController;
import org.junit.Test;
import org.mockito.Mockito;

public class ControllerTest extends Mockito {

  @Test
  public void testServlet() throws Exception {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);

    when(request.getParameter("username")).thenReturn("me");
    when(request.getParameter("password")).thenReturn("secret");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(writer);

    CarsController controller = new CarsController();
    controller.service(request, response);

    verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
    writer.flush(); // it may not have been flushed yet...
    assertTrue(stringWriter.toString().contains("My expected string"));
  }
}