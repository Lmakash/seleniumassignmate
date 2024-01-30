package Lab_selenium;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12_DemoCart_Properties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStream input1=new FileInputStream("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\src\\test\\java\\Lab_selenium\\lab12democart.properties");
		Properties prop = new Properties();
		prop.load(input1);
		String url = prop.getProperty("url");
		String p1 = prop.getProperty("product");
		String p2 = prop.getProperty("product2");
		System.out.println("The URL is: "+ url);
		System.out.println("The product is: "+ p1);
		System.out.println("The product2 is: "+ p2);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		LAB12_DemoCart_POM obj = new LAB12_DemoCart_POM(driver);
		obj.desktop();
		obj.mac();
		obj.sort(1);
		obj.search();
		obj.search2(p1);
		
		obj.tick();
		obj.searchbutton();
		driver.navigate().back();
		
		obj.clear1();
		Thread.sleep(2000);
		obj.search2(p2);
		obj.searchbutton();
	}
	}


