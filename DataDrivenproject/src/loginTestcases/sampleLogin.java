package loginTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleLogin {

	public static void main(String[] args)
	    {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\WELCOME\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 WebDriver driver = new ChromeDriver();
			 
			 driver.get("https://opensource-demo.orangehrmlive.com/");
			 
			 WebElement username = driver.findElement(By.id("txtUsername"));
			 username.sendKeys("admin");
			 
			 WebElement password = driver.findElement(By.id("txtPassword"));
			 username.sendKeys("admin123");
			 
			 WebElement loginbutton = driver.findElement(By.id("btnLogin"));
			 loginbutton.click();
	    }
	    
}
