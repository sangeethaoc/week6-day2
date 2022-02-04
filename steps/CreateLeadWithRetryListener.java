package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLeadWithRetryListener extends InitialClass 
{
	@BeforeClass
	public void setUp()
	{
		fileName = "CreateLead";
	}
	
	@Test(dataProvider = "sendData")
	public void createLead(String companyName, String firstName, String lastName) {

		// Click Leads tab
		driver.findElement(By.linkText("Leads")).click();

		// Click Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);

		// Enter First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);

		// Enter Last Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);

		// Enter Birth Date
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("01/02/22");

		// Create object for Select class
		Select sourceDropDownSelect = new Select(driver.findElement(By.id("createLeadForm_dataSourceId")));
		sourceDropDownSelect.selectByVisibleText("Employee");

		// Contact Information

		// Enter Area Code
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("22");

		// Enter Phone Number
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9790573762");

		// Enter Extension
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("+91");

		// Enter Person Name
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Sangeetha");

		// Enter Primary Email
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sangeethaoc@gmail.com");

		// Enter Primary URL
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("http://sangeethaoc@gmail.com");

		// Primary Address

		// Enter Reciepient Name
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Sangeetha");

		// Enter Attention Name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Sangeetha");

		// Enter Address Line 1
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("H918,Rajiv Gandhi Street");

		// Enter Address Line 2
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Sholinganallur");

		// Enter City
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");

		// Select Country
		Select countrySelect = new Select(driver.findElement(By.id("createLeadForm_generalCountryGeoId")));
		countrySelect.selectByVisibleText("India");

		// Enter Postal Code
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("638030");

		// Enter Postal Code Extension
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("12");

		// Enter State
		WebElement stateWE = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateSelect = new Select(stateWE);
		stateSelect.selectByValue("IN-TN");

		// Click Create Lead button
		driver.findElement(By.className("smallSubmit")).click();

		String pageTitle = driver.getTitle();
		// Print Page Title
		if (pageTitle.startsWith("View Lead")) {
			System.out.println("Page Title Received is as expected");
			System.out.println("Page Title : " + driver.getTitle());
		} else
			System.out.println("Page Title is not as expected");

	}
	
}
