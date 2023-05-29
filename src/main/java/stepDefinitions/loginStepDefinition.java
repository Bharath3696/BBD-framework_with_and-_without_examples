package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStepDefinition {
	
	WebDriver driver;
	//@Before
	//@Given("^user is already on Login page$")
	public void user_is_already_on_Login_page()  {
	    System.setProperty("webdriver.chrome.driver","A:\\crm\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
	    
	    //throw new PendingException();
	}

	@When("^title of login page is Free CRM  - CRM software for customer relationship management, sales, and support$")
	public void title_of_login_page_is_Free_CRM_CRM_software_for_customer_relationship_management_sales_and_support()  {
	    String as = driver.getTitle();
	    System.out.print(as);
	    Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.",as);
	    //throw new PendingException();
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String pwdd)  {
	   
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(pwdd);
	
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
	    
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

    @Then("^user is on home page$")
	public void user_is_on_home_page()  {
	    String ad = driver.getTitle();
	    System.out.println(ad);
	    Assert.assertEquals("CRMPRO", ad);
	    //driver.quit();
	    } 
    
    @Then("^user mouse over to contact and clicks new contact$")
	public void user_mouse_over_to_contact_and_clicks_new_contact() 
	{
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='mlddm']/li/a[@title='Contacts']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		  
	}

	@Then("^user create new contact \"(.*)\" \"(.*)\"$")
	public void user_create_new_contact(String fst, String lst) {
	    driver.findElement(By.id("first_name")).sendKeys(fst);
	    driver .findElement(By.id("surname")).sendKeys(lst);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

	@Then("^verifying the created contact exist or not \"(.*)\"$")
	public void verifying_the_created_contact_exist_or_not(String fullname)  {
		driver.findElement(By.xpath("//ul[@class='mlddm']/li/a[@title='Contacts']")).click();
		boolean j = driver.findElement(By.xpath("//a[contains(text(), '"+fullname+"')]")).isDisplayed();
		Assert.assertTrue(j);
	}
    //@After
	//@Then("^close the browser$")
	public void close_the_browser()  {

      driver.quit();
	    
	}

}
