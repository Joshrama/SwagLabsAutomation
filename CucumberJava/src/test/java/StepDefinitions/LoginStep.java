package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.support.ui.Select;

import Hooks.TakeScreenshot;
import io.cucumber.java.en.*;

public class LoginStep {
	
	WebDriver driver = null;
	
	@SuppressWarnings("deprecation")
	@Given("user access the website login page")
	public void user_access_the_website_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com");
		
	}

	@When("user enter valid username and password")
	public void user_enter_valid_username_and_password()throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(3000);
	  
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("login-button")).click();
	
	   
	}

	@Then("user should be navigated to the products page")
	public void user_should_be_navigated_to_the_products_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Swag");
	}

	@When("user sort products by the highest price")
	public void user_sort_products_by_the_highest_price() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByValue("hilo");
    	Thread.sleep(3000);
		
	}

	@And("user verify that the products have the highest price")
	public void user_verify_that_the_products_have_the_highest_price() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Sauce Labs Fleece Jacket");
	}

	@And("user click on the add to cart button for the most expensive product")
	public void user_click_on_the_add_to_cart_button_for_the_most_expensive_product() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(3000);
	    
	}

	@And("user click on the shopping cart badge")
	public void user_click_on_the_shopping_cart_badge() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("shopping_cart_container")).click();
		Thread.sleep(3000);
	}

	@Then("user should be navigated to the cart page")
	public void user_should_be_navigated_to_the_cart_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Sauce Labs Fleece Jacket");
	    
	}

	@When("user verify that the correct product is added to the cart")
	public void user_verify_that_the_correct_product_is_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Sauce Labs Fleece Jacket");
	    
	}

	@And("user click on the checkout button")
	public void user_click_on_the_checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("checkout")).click();
	}

	@Then("user should be navigated to the checkout step one page")
	public void user_should_be_navigated_to_the_checkout_step_one_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Information");
	 
	}

	@When("user enter the required details on checkout page")
	public void user_enter_the_required_details_on_checkout_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("firstName")).sendKeys("Hatos");
		driver.findElement(By.name("lastName")).sendKeys("sese");
		driver.findElement(By.name("postalCode")).sendKeys("12345");
		Thread.sleep(3000);
	}

	@And("user click the continue button")
	public void user_click_the_continue_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		driver.findElement(By.name("continue")).click();
	  
	}

	@Then("user should be navigated to the checkout step two page")
	public void user_should_be_navigated_to_the_checkout_step_two_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Information");
	    
	}

	@When("user verify the order status")
	public void user_verify_the_order_status() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Price Total");
	}

	@And("user click the finish button")
	public void user_click_the_finish_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
	    driver.findElement(By.name("finish")).click();
	}

	@Then("user should be navigated to the checkout complete page")
	public void user_should_be_navigated_to_the_checkout_complete_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.getPageSource().contains("Thank you for your order!");
	 
	}

	@Then("user capture the screen")
	public void user_capture_the_screen() throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		
			
			File screenshot = ((HasFullPageScreenshot) DriverManager.getDriver(null)).getFullPageScreenshotAs(OutputType.FILE);
			try{
				FileUtils.copyFile(screenshot, new File("screenshot.jpg"));
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		driver.close();

	}
}


