package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadWithCommonMethod extends SubClass
{
	
	@When("Click on {string} link")
	public void clickLink(String link)
	{
		driver.findElement(By.linkText(link)).click();
	}
	
	@Then("{string} page is displayed")
	public void verifyPage(String page)
	{
		 boolean isDisplayed = driver.findElement(By.linkText(page)).isDisplayed();
		 System.out.println();
		 Assert.assertTrue(isDisplayed);
		 
		 if(isDisplayed)
			 System.out.println("The expected page : "+page+" is displayed");
		 else
			 System.out.println("The expected page : "+page+" is not displayed");
	}
	
	@Given("Click on {string} button")
	public void clickLogin(String button) throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(By.className(button)).click();
		
	}
		
	@Given("Enter Company Name as {string}")
	public void enterCompanyName(String companyName)
	{
		// Enter Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	
	@Given("Enter First Name as {string}")
	public void enterFirstName(String firstName)
	{
		// Enter First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	
	@Given("Enter Last Name as {string}")
	public void enterLastName(String lastName)
	{
		// Enter Last Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}

}
