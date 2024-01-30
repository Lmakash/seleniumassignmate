package Lab_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab14_OpenCartRegister {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.opencart.com/");
    driver.findElement(By.linkText("My Account")).click();
    Thread.sleep(4000);
    driver.findElement(By.linkText("Register")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Akash");
    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("shendage");
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");
    driver.findElement(By.xpath("//input[@id='input-newsletter-no\']")).click();
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    System.out.println("you are successfully Register");
    Thread.sleep(4000);
    driver.quit();
}
}
