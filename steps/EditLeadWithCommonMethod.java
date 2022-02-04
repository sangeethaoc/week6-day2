package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadWithCommonMethod extends SubClass{
	
	String compName = "";
	
	@When("Click on {string} link")
	public void clickLink(String link)
	{
		driver.findElement(By.linkText(link)).click();
		//driver.findElement(By.linkText("Leads")).click();
	}

	@Given("First Name as {string}")
	public void enterFirstName(String firstName) {
		// Enter First Name
		driver.findElement(By.xpath("(//input[@name='firstName'])[last()]")).sendKeys(firstName);

	}

	@Then("Click on {string} button")
	public void clickOnFindLeadsButton(String buttonName) {
		// Click Find Leads button
		driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();

	}

	@When("Click on First Lead displayed")
	public void clickOnFirstLead() throws InterruptedException {
		Thread.sleep(3000);
		// Click First Lead
		WebElement leadIDWE = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a[1]"));
		leadIDWE.click();
	}

	@Then("Click on Edit button")
	public void clickOnEditButton() {
		// Click Edit on View Lead page
		driver.findElement(By.xpath("//a[text()= 'Edit']")).click();

	}

	@Given("Enter Company Name as {string}")
	public void enterCompanyName(String companyName) 
	{
		// Change the Company Name
		compName = companyName;
		WebElement compNameWE = driver.findElement(By.id("updateLeadForm_companyName"));
		compNameWE.clear();
		compNameWE.sendKeys(companyName);
	}

	@When("Click on Update Button")
	public void clickUpdateButton() {
		// Click on Update
		driver.findElement(By.className("smallSubmit")).click();
	}

	@Then("Verify Company Name is updated")
	public void verifyViewLeadPage() {
		
		// Verify if the changed value displays in the View Lead page
		String updatedCompName = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		if (updatedCompName != null && updatedCompName.startsWith(compName))
			System.out.println("The Company Name has been updated with its new value.");
		else
			System.out.println("The Company Name has not been updated with its new value.");

	}

}
