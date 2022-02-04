package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubClass extends AbstractTestNGCucumberTests{
	
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void preCondition() {

		// Setup the driver
		WebDriverManager.chromedriver().setup();

		// Launch the chrome browser
		driver = new ChromeDriver();

		// Load the url
		driver.get("http://leaftaps.com/opentaps/");

		// Maximize the browser window
		driver.manage().window().maximize();

		// Implicit Wait of 2 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		// Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Enter the password"
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click on Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
