package StepDefinitions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class AddTaskStepDefinitions {

	  private AppiumDriver<MobileElement> driver;

	    @Before
	    public void setup() throws Exception {
	        // Set up desired capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
	        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	        caps.setCapability(MobileCapabilityType.APP, "path/to/app.apk");

	        // Initialize driver
	        URL url = new URL("http://localhost:4723/wd/hub");
	        driver = new AndroidDriver<>(url, caps);

	        // Set implicit wait
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    
    @Given("I am on the home screen")
    public void iAmOnTheHomeScreen() {
        // Make sure the app is launched and the home screen is visible
    

    }
    @When("I tap the Add Task button")
    public void iTapTheAddTaskButton() {
        // Tap the "Add Task" button
    	 MobileElement addTaskButton = driver.findElement(MobileBy.id("addTaskButton"));
         addTaskButton.click();
    }
    @And("I enter the task name")
    public void i_enter_the_task_name(String taskName) {
        // Write code here that turns the phrase above into concrete actions

    	 MobileElement taskNameField = driver.findElement(MobileBy.id("taskNameField"));
         taskNameField.sendKeys(taskName);
       
    }
    @And("I choose date {string} date and time {string} time")
    public void ichoosedateandtime(String date,String time) {
    	MobileElement dateTimeField = driver.findElement(MobileBy.id("dateTimeField"));
        dateTimeField.click();
        EditText dateField = driver.findElement(By.id("date_field_id"));
        dateField.click();
        DatePicker datePicker = (DatePicker) driver.findElement(By.id("date_picker_id"));
        datePicker.updateDate(date); // Set the desired date
        driver.findElement(By.id("date_picker_ok_button_id")).click();
        EditText timeField = driver.findElement(By.id("time_field_id"));
        timeField.click();
        TimePicker timePicker = (TimePicker) driver.findElement(By.id("time_picker_id"));
        timePicker.setHour(6); // Set the desired hour
        timePicker.setMinute(30); // Set the desired minute
        driver.findElement(By.id("time_picker_ok_button_id")).click();
    }
    @And("And I select repeat to other and select with {string}weeks weeks")
    public void selectrepeat(String repeatFrequency) {
        MobileElement repeatToOtherToggle = driver.findElement(MobileBy.id("repeatToOtherToggle"));
        repeatToOtherToggle.click();
        MobileElement repeatOptionDropdown = driver.findElement(MobileBy.id("repeatOptionDropdown"));
        repeatOptionDropdown.click();
        MobileElement dropdown = driver.findElement(By.id("repeatDropdown"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("repeatOption")));
        MobileElement option = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Other']"));
        option.click();
        MobileElement repeatFrequencyField = driver.findElement(MobileBy.id("repeatFrequencyField"));
        repeatFrequencyField.sendKeys(repeatFrequency);

    }
    @And("I tap the set button"){
    WebElement setButton = driver.findElement(By.id("set_button_id"));
    setButton.click();
    }
    @And ("I select personal on Add to list"){
    	WebElement checkButton = driver.findElement(By.id("check_button_id"));
    	checkButton.click();
    }
    @Then("the task {string}taskName should be added to the list"){
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("listView")));
    	MobileElement task = driver.findElement(By.xpath("//android.widget.TextView[@text='" + taskName + "']"));
    	Assert.assertTrue(task.isDisplayed());
    	driver.quit();
    }
    
}
    
