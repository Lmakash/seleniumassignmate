package Lab_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
 class Lab4_DemoCart_Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		
		Lab4_DemoCart_POM obj = new Lab4_DemoCart_POM(driver);
		obj.desktop();
		obj.mac();
		obj.sort(1);
		obj.search();
		obj.search2("Mobile");
		obj.tick();
		obj.searchbutton();
		
		Lab4_DemoCart_PageFactory obj1= PageFactory.initElements(driver, Lab4_DemoCart_PageFactory.class);
			obj1.desktop();
			obj1.mac();
			obj1.sort(1);
			obj1.search();
			obj1.search2("Mobile");
			obj1.tick();
			obj1.searchbutton();

	}
}
