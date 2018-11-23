package sri.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sri.object.ui.ActiTimeLoginPage;
import sri.utils.CreateDriver;

public class LoginPageSmokeTest {
	
	WebDriver driver;
	ActiTimeLoginPage login;
	
	@BeforeMethod
	public void preCondition() {
		driver = CreateDriver.getDriverInstance();
		login = new ActiTimeLoginPage(driver);
	}
	
	@AfterMethod
	public void postCondtion() {
		driver.close();
	}
	
	@Test
	public void testLoginPage() {
		login.waitForLoginPageToLoad();
		String actualTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
