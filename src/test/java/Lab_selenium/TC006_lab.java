package Lab_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_lab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.opencart.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
			System.out.println(driver.getTitle());
			driver.findElement(By.linkText("My Account")).click();
			driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.name("email")).sendKeys("Akash@gmail.com");
			driver.findElement(By.name("password")).sendKeys("akash@12");
			driver.findElement(By.tagName("button")).click();
			
			WebElement ele = driver.findElement(By.linkText("Components"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.linkText("Monitors (2)")).click();
			driver.manage().window().maximize();
			
			Select show = new Select(driver.findElement(By.xpath("//select[@id=\"input-limit\"]")));
			show.selectByIndex(1);
			
			 JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("alert('Hello');");
				
				//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			js.executeScript("window.scrollBy(0,500)");
            driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[1]/form/div/div[1]/a/img")).click();
           // JavascriptExecutor js1=(JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,500)");
            driver.findElement(By.xpath( "//*[@id=\"input-option-value-6\"]")).click();
            js.executeScript("window.scrollBy(0,100)");
            driver.findElement(By.xpath("//*[@id=\"input-option-223\"]/div[2]/label")).click();
            js.executeScript("window.scrollBy(0,100)");
            driver.findElement(By.xpath("//*[@id=\"input-option-208\"]")).sendKeys("test12");
            js.executeScript("window.scrollBy(0,100)");
            Select s1=new Select(driver.findElement(By.xpath("//*[@id=\"input-option-208\"]")));
            s1.selectByIndex(2);
	}

}
