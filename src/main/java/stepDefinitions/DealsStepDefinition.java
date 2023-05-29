package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DealsStepDefinition {
	

	WebDriver driver;
	
	@Given("^user is logging in$")
	public void user_is_logging_in(DataTable arg1)  {
		
	    System.setProperty("webdriver.chrome.driver","A:\\crm\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://classic.freecrm.com/");
	    List<List<String>> d1 = arg1.raw();
	    driver.findElement(By.name("username")).sendKeys(d1.get(0).get(0));
	    driver.findElement(By.name("password")).sendKeys(d1.get(0).get(1));
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    
	}

	@Then("^user is on home page hall$")
	public void user_is_on_home_page_hall()  {
	    String yr = driver.getTitle();
	    System.out.println("Home page title : "+yr);
	    
	}
	@Then("^user clicks deals$")
	public void user_clicks_deals()  {
	    driver.switchTo().frame("mainpanel");
	    Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//a[@title ='Deals']"))).build().perform();
	    driver.findElement(By.xpath("//a[@title ='New Deal']")).click();
	    }

	@Then("^user enter the deal details$")
	public void user_enter_the_deal_details(DataTable argd) throws IOException, InterruptedException  {
		List<List<String>>as = argd.raw();
	    driver.findElement(By.name("title")).sendKeys(as.get(0).get(0));
	    driver.findElement(By.name("client_lookup")).sendKeys(as.get(0).get(1));
	    driver.findElement(By.name("contact_lookup")).sendKeys(as.get(0).get(2));
	    driver.findElement(By.name("amount")).sendKeys(as.get(0).get(3));
	    driver.findElement(By.name("probability")).sendKeys(as.get(0).get(4));
	    driver.findElement(By.xpath("//input[@type= 'submit']")).click();
	    
	    Thread.sleep(3000);
	    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile( file ,new File("A:\\test.png"));
	    
	    
	}

	@Then("^close everything$")
	public void close_everything()  {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}



}
