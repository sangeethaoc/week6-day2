package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAssertion {
	@Test
	public void learnAssertion() {

		// Setup the driver
		WebDriverManager.chromedriver().setup();

		// Launch the driver
		ChromeDriver chromeDriver = new ChromeDriver();

		// Load the url
		chromeDriver.get("http://leaftaps.com/opentaps/");

		// Maximize the browser
		chromeDriver.manage().window().maximize();

		// Enter the Username
		WebElement userName = chromeDriver.findElement(By.id("username"));

		userName.sendKeys("DemoSalesManager");

		// Enter the password"
		chromeDriver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click Submit button
		chromeDriver.findElement(By.className("decorativeSubmit")).click();

		// Click CRM/SFA
		chromeDriver.findElement(By.linkText("CRM/SFA")).click();

		// Click Create Lead button
		chromeDriver.findElement(By.className("smallSubmit")).click();
		// Click Leads tab
		chromeDriver.findElement(By.linkText("Leads")).click();

		// Click Create Lead
		chromeDriver.findElement(By.linkText("Create Lead")).click();

		// Enter Company Name
		chromeDriver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");

		// Enter First Name
		chromeDriver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sangeetha");

		// Enter Last Name
		chromeDriver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mathivanan");

		String pageTitle = chromeDriver.getTitle();
		// Print Page Title
		/*
		 * if (pageTitle.startsWith("View Lead")) {
		 * System.out.println("Page Title Received is as expected");
		 * System.out.println("Page Title : " + chromeDriver.getTitle()); } else
		 * System.out.println("Page Title is not as expected");
		 */
		//Hard Assert
		Assert.assertEquals(pageTitle, "View Lead");
		
		//SoftAssert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(pageTitle, "View Lead");
		
		System.out.println("Last line of code");
		
		//Throws all the assertion error encountered till now and 
		//Mark the test case as Failed
		softAssert.assertAll();
	}

}
