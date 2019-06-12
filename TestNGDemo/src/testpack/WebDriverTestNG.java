package testpack;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebDriverTestNG {
	WebDriver driver;

	  @Test(dataProvider = "dp")
	  public void f(String un, String pwd, String winTitle) {
			String actTitle = driver.getTitle();
			assertEquals(winTitle, actTitle);
			driver.findElement(By.name("userName")).sendKeys(un);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.name("login")).click();
			List<WebElement> trip=driver.findElements(By.name("tripType"));
			String tData="oneway";
			for(WebElement t:trip)
			{
				if(t.getAttribute("value").equals(tData))
				{
					t.click();
				}
			}
			driver.findElement(By.linkText("SIGN-OFF")).click();
	  }
	 
	  @BeforeMethod
	  public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\selenium jars\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			driver.manage().window().maximize();
	  }

	  @AfterMethod
	  public void afterMethod() {
			driver.close();
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "mercury", "mercury","Welcome: Mercury Tours" },
	      new Object[] { "test", "testone","Welcome: Mercury Tours" },
	    };
	  }

}
