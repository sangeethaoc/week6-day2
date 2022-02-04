package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLeadWithCommonMethod extends SubClass {
	
	String leadID = "";
	
	@When("Click on {string} link")
	public void clickLeadsTab(String link) {
		// Click Leads tab
		driver.findElement(By.linkText(link)).click();
	}

	@When("Click on First Lead link displayed")
	public void clickOnFirstLead() throws InterruptedException {
		Thread.sleep(3000);
		// Click First Lead
		WebElement leadIDWE = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		leadID = leadIDWE.getText();
		leadIDWE.click();
	}
	
	@Then("Click on Delete button")
	public void clickOnDeleteButton()
	{
		//Click Delete Lead
		driver.findElement(By.className("subMenuButtonDangerous")).click();
	}
	
	@Given("Enter Lead ID")
	public void enterLeadID()
	{
		// Enter LeadID which was deleted in previous step
		driver.findElement(By.name("id")).sendKeys(leadID);
	}
	
	@When("Click on Find Leads button")
	public void clickOnFindLeadsButton()
	{
		// Click Find Leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		
	}
	
	
	@Then("Confirm the given Lead ID is deleted")
	public void confirmGivenLeadIDIsDeleted() throws InterruptedException
	{
		Thread.sleep(3000);
		// Confirm if the lead is deleted successfully
		WebElement displayMsgWE = driver.findElement(By.className("x-paging-info"));
		String displayMsg = displayMsgWE.getText();
		System.out.println(("Display Message : "+displayMsg));
		 
		//Hard Assert for validating the output page
		Assert.assertEquals(displayMsg, "No records to display");

	}	
}
