package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class taggedHooksstepdef {
	

@Before(order =0)
public void user_is_already_on_Login_page() {
    System.out.println("User loged in the system");
    
}

@After(order =0)
public void close_the_browser() throws Throwable {
	System.out.println("browser closed");
    
}

@Before("@first")
public void specific_for_first()
{
	System.out.println("@before method for first scenario");
}
@Then("^checked login$")
public void checked_login() throws Throwable {
	System.out.println("step 1 executed");
    
}

@Then("^user seeing home page$")
public void user_seeing_home_page() throws Throwable {
	System.out.println("step 2 executed");
    
}

@After("@first")
public void last_specific_for_first()
{
	System.out.println("@last method first scenario");
}

@Before("@second")
public void specific_for_second()
{
	System.out.println("@before method for second scenario");
}
@Then("^user clicked contact$")
public void user_clicked_contact() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^user enters contact details$")
public void user_enters_contact_details() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@After("@second")
public void last_specific_for_second()
{
	System.out.println("@last method for second scenario");
}

@Before("@third")
public void specific_for_third()
{
	System.out.println("@before method for third scenario");
}
@Then("^user enters deal page$")
public void user_enters_deal_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^user file deals details$")
public void user_file_deals_details() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}
@After("@third")
public void last_specific_for_third()
{
	System.out.println("@last method for third scenario");
}

}
