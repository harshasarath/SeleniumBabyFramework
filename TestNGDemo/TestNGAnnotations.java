package testpack;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeMethod
	public void demoBfr()
	{
		System.out.println("Launch Application");
	}
	
	@Test(dependsOnMethods="demoTest1",alwaysRun=true)
	public void demoTest()
	{
		System.out.println("Validate Test Case 2");
	}
	
	@Test
	public void demoTest1()
	{
		System.out.println("Validate Test Case 1");
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void demoAft()
	{
		System.out.println("Close Application");
	}

}
