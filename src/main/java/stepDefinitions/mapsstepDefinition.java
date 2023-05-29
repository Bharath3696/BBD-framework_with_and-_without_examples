package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

public class mapsstepDefinition {
	
	WebDriver driver;

@Given("^user is logging in maps$")
public void user_is_logging_in_maps(DataTable arg1)  {
	System.setProperty("webdriver.chrome.driver","A:\\crm\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://classic.freecrm.com/");
    for(Map<String, String> d11 : arg1.asMaps(String.class, String.class))
    {
    driver.findElement(By.name("username")).sendKeys(d11.get("Username"));
    driver.findElement(By.name("password")).sendKeys(d11.get("password"));
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    
}

@Then("^user is on home page hall maps$")
public void user_is_on_home_page_hall_maps()  {
	String yr = driver.getTitle();
    System.out.println("Home page title : "+yr);
    
    
}

@Then("^user clicks deals maps$")
public void user_clicks_deals_maps()  {
	driver.switchTo().frame("mainpanel");
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[@title ='Deals']"))).build().perform();
    driver.findElement(By.xpath("//a[@title ='New Deal']")).click();
    }


@Then("^user enter the deal details maps$")
public void user_enter_the_deal_details_maps(DataTable arg1) throws InterruptedException, IOException {
	for(Map<String, String>asa : arg1.asMaps(String.class, String.class))
	{
		//String kk = asa.get("Primary_contact");
    driver.findElement(By.xpath("//input[@name= 'title']")).sendKeys(asa.get("Title"));
    driver.findElement(By.name("client_lookup")).sendKeys(asa.get("Companye"));
    driver.findElement(By.name("contact_lookup")).sendKeys(asa.get("Primary_contact"));
    driver.findElement(By.name("amount")).sendKeys(asa.get("Amount"));
    driver.findElement(By.name("probability")).sendKeys(asa.get("Probability"));
    driver.findElement(By.xpath("//input[@type= 'submit']")).click();
    
   // Thread.sleep(3000);
    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
    FileUtils.copyFile( file ,new File("A:\\test"+asa.get("Primary_contact")+".png"));
    
   // driver.switchTo().frame("leftpanel");
    
    //driver.navigate().refresh();
   
    Actions act1 = new Actions(driver);
    act1.moveToElement(driver.findElement(By.xpath("//a[@title ='Deals']"))).build().perform();
    driver.findElement(By.xpath("//a[@title ='New Deal']")).click();
    
    
	}
    
    
}

@Then("^close everything maps$")
public void close_everything_maps()  {
    driver.quit();
    
}



}
