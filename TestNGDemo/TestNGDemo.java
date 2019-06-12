package testpack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TestNGDemo {
  @Test(dataProvider = "dp")
  public void f(String un, String pwd, String winTitle) {
	  System.out.println(un +"--->" +pwd+"-------->"+winTitle);
  }
 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Launch Application");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Close Application");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "mercury", "mercury","Welcome: Mercury Tours" },
      new Object[] { "test", "testone","Welcome: Mercury Tours" },
    };
  }
}
