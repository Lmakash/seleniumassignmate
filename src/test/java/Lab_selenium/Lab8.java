package Lab_selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab8 {
	 WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String email, String password) throws InterruptedException {
//	      WebDriverManager.chromedriver().setup();
//	        WebDriver driver=new ChromeDriver();
//	        driver.get("https://demo.opencart.com/");
//	        driver.manage().window().maximize();
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	        
	        driver.findElement(By.linkText("My Account")).click();
	        driver.findElement(By.linkText("Login")).click();
	        driver.findElement(By.id("input-email")).sendKeys(email);
	        driver.findElement(By.id("input-password")).sendKeys(password);
	        driver.findElement(By.tagName("button")).click();
	        driver.findElement(By.linkText("Desktops")).click();
	        driver.findElement(By.linkText("Mac (1)")).click();
	        Select s1=new Select(driver.findElement(By.id("input-sort")));
	        List<WebElement> l1=s1.getOptions();
	        s1.selectByIndex(1);
	        
	        JavascriptExecutor js=(JavascriptExecutor)driver;  
	        js.executeScript("window.scrollBy(0,500);");
	        driver.findElement(By.linkText("iMac")).click();
	        JavascriptExecutor js1=(JavascriptExecutor)driver;  
	        js1.executeScript("window.scrollBy(0,200);");
	        Thread.sleep(1000);
	        driver.findElement(By.id("button-cart")).click();
	        
	  }
	  @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver=new ChromeDriver();
	        driver.get("https://demo.opencart.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	       
//	        driver.findElement(By.linkText("Desktops")).click();
//	        driver.findElement(By.linkText("Mac (1)")).click();
//	        Select s1=new Select(driver.findElement(By.id("input-sort")));
//	        List<WebElement> l1=s1.getOptions();
//	        s1.selectByIndex(1);
//	        
//	        JavascriptExecutor js=(JavascriptExecutor)driver;  
//	        js.executeScript("window.scrollBy(0,500);");
//	        driver.findElement(By.linkText("iMac")).click();
//	        JavascriptExecutor js1=(JavascriptExecutor)driver;  
//	        js1.executeScript("window.scrollBy(0,200);");
//	        Thread.sleep(1000);
//	        driver.findElement(By.id("button-cart")).click();
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Akash@gmail.com", "rahul111" },
	      };
	  }
	  @BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
	  }

	  @BeforeTest
	  public void beforeTest() {
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	  @BeforeSuite
	  public void beforeSuite() {
	  }

	  @AfterSuite
	  public void afterSuite() {
	  }

	}