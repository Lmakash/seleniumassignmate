package Lab_selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB3 {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) throws InterruptedException {
			
			 WebDriverManager.chromedriver().setup();
				
				WebDriver driver= new ChromeDriver();
				
				driver.get("http://demo.opencart.com");
				
				lab11_POM obj=new lab11_POM(driver);
				
				obj.clickOnDeskstops();
				obj.clickOnMac();
			    obj.handledropdown();
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,800)");
				obj.clickonaddcart();
		}
	}


