package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLeadWithCommonMethod extends SubClass {
	
	String firstNameActual = "";
	String lastNameActual = "";
	
	@When("Click on {string} link")
	public void clickLeadsTab(String link) {
		// Click Leads tab
		driver.findElement(By.linkText(link)).click();
	}

	@When("Click Email link")
	public void clickEmailLink()
	{
		// Click Email link
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}
	
	@Given("Enter Email Address as {string}")
	public void enterEmailAddress(String emailAddress)
	{
		// Enter Email Address
		driver.findElement(By.xpath("(//label[text()='Email Address:']/following::input)[1]")).sendKeys(emailAddress);
		
	}
	
	@When("Click on Find Leads button")
	public void clickOnFindLeadsButton()
	{
		// Click Find Leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
	}
	
	@Then("Click on First Lead item displayed")
	public void clickOnFirstLeadItem() throws InterruptedException
	{
		Thread.sleep(3000);
		// Click First Lead
		WebElement leadIDWE = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String leadID = leadIDWE.getText();
		leadIDWE.click();
		
		// Get First Name of the original lead 
		firstNameActual = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		// Get Last Name of the original lead
		lastNameActual = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		
		System.out.println("Page Title : "+driver.getTitle());
		System.out.println("First Name of  Actual Lead before duplication : " +firstNameActual);
		System.out.println("Last Name of  Actual Lead before duplication : " +lastNameActual);
		
	}
	
	@When("Click on Duplicate Lead link")
	public void clickOnDuplicateLeadLink()
	{
		// Click Duplicate Lead link
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
	}
	
	@Then("Click on Create Lead button")
	public void clickOnCreateLeadButton()
	{
		// Click Create Lead button
		driver.findElement(By.className("smallSubmit")).click();
	}
	
	@And("Verify if Duplicated Lead is same as Actual Lead")
	public void verifyIfLeadisDuplicated()
	{
		// Get First Name of the duplicated lead 
		String firstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		// Get Last Name of the duplicated lead
		String lastName = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		
		System.out.println("Page Title : "+driver.getTitle());
		System.out.println("First Name of  Duplicated Lead before duplication : " +firstName);
		System.out.println("Last Name of  Duplicated Lead before duplication : " +lastName);
		
		Assert.assertEquals(firstName, firstNameActual);
		Assert.assertEquals(lastName, lastNameActual);
	}
	
}
