package Lab_selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab3main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		 WebDriverManager.chromedriver().setup();
			
		 WebDriver driver= new ChromeDriver();
			
			driver.get("http://demo.opencart.com");
			  
			Lab3_DemoCart_PageFactory obj = PageFactory.initElements(driver, Lab3_DemoCart_PageFactory.class);
				obj.desktop();
				obj.mac();
				obj.sort(1);
				
				JavascriptExecutor js =(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				Thread.sleep(3000);
				
				obj.addcart();
	}

}
