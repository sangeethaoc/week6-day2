package steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadExcel;

public class InitialClass {
	//Declare the global variable
		public static RemoteWebDriver driver;
		
		//Declare fileName for every class name
		String fileName;
		
		@BeforeMethod(alwaysRun = true)
		@Parameters({"browser","url","username","password"})
		public void beforeMethod(String browser, String url, String username, String password)
		{
					if(browser.equalsIgnoreCase("Chrome"))
					{
						// Setup the driver
						WebDriverManager.chromedriver().setup();
						// Launch the driver
						driver = new ChromeDriver();

					}
					else if(browser.equalsIgnoreCase("Edge"))
					{
						// Setup the driver
						WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
					}
					
					// Load the url
					driver.get(url);

					// Maximize the browser
					driver.manage().window().maximize();

					// Enter the Username
					WebElement userName = driver.findElement(By.id("username"));

					userName.sendKeys(username);

					// Enter the password"
					driver.findElement(By.id("password")).sendKeys(password);

					// Click Submit button
					driver.findElement(By.className("decorativeSubmit")).click();

					// Click CRM/SFA
					driver.findElement(By.linkText("CRM/SFA")).click();
		}
		
		@AfterMethod(alwaysRun = true)
		public void afterMethod()
		{
			System.out.println("After Method");
			//chromeDriver.close();
		}
		
		@DataProvider
		public String[][] sendData() throws IOException
		{
			//Call readDataFromExcel method to read data from excel file.
			String[][] data = ReadExcel.readDataFromExcel(fileName);
			return data;
		}
}
