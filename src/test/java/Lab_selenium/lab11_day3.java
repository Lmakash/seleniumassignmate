package Lab_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab11_day3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement ele=driver.findElement(By.linkText("Desktops"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
	driver.findElement(By.linkText("Mac (1)")).click();
	Select sort= new Select(driver.findElement(By.id("input-sort")));
	sort.selectByIndex(1);
	
	 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@id=\"product-list\"]/div/form/div/div[1]/a/img")).click();
		 driver.findElement(By.id("button-cart")).click();
		 
		 
		         
	}

}
