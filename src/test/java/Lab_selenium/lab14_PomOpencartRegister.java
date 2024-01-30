package Lab_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class lab14_PomOpencartRegister {
	
		WebDriver driver;
		By fname = By.name("firstname");
		By lname = By.name("lastname");
		By email = By.name("email");
		By pwd = By.name("password");
	    By rdobtn = By.id("input-newsletter-no");
		By check = By.xpath("//*[@id=\"form-register\"]/div/div/div/input");
		By btn = By.xpath("//button[@type='submit']");
		
		public lab14_PomOpencartRegister(WebDriver driver2) {
			// TODO Auto-generated constructor stub
			this.driver=driver2;
		}

		public void enterfirstname(String firstname1) {
			driver.findElement(fname).sendKeys(firstname1);
		}
		
		public void enterlastname(String lastname1) {
			driver.findElement(lname).sendKeys(lastname1);
		}
		
		public void enteremail(String email1) {
			driver.findElement(email).sendKeys(email1);
		}
		public void enterpassword(String password1) {
			driver.findElement(pwd).sendKeys(password1);
		}
		
		public void enterradiobutton() {
			driver.findElement(rdobtn).click();
		}
		public void entercheckbox() {
			driver.findElement(check).click();
		}
		public void enterbutton2() {
			driver.findElement(btn).click();
		}
	

	}

