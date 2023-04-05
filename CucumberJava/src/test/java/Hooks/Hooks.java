package Hooks;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import org.openqa.selenium.OutputType;

public class Hooks extends BaseClass{
	
	public void takeScreenshot() {
		
		File screenshot = ((TakeScreenshot) DriverManager.getDriver(null)).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(screenshot, new File("screenshot.jpg"));
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}