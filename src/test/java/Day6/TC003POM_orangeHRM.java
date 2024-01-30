package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC003POM_orangeHRM {
	WebDriver driver;
	  By uname=By.name("username");
	  By pword=By.name("password");
	  By loginbutton=By.xpath("//button[@type='submit']");
	  By dashboard=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
	  
	  public TC003POM_orangeHRM(WebDriver driver2) {
		  this.driver=driver2;
	  }
	  public boolean verifyusername()
		{
			boolean isusername_displayed=driver.findElement(uname).isDisplayed();
			return isusername_displayed;
		}
	  
	  public void enterusername(String username) {
		  driver.findElement(uname).sendKeys(username);
	  }
	  public boolean verifypassword()
		{
			boolean ispassword_displayed=driver.findElement(pword).isDisplayed();
			return ispassword_displayed;
		}
	  public void enterpassword(String password) {
		  driver.findElement(pword).sendKeys(password);
	  }
	 
	  public boolean verifylogin()
		{boolean isdashboard_displayed;
			try
			{
			 isdashboard_displayed=driver.findElement(dashboard).isDisplayed();
			}
			catch(Exception e)
			{
				isdashboard_displayed=false;
			}
			
			return isdashboard_displayed;
		}
	  public void clicklogin() {
		  driver.findElement(loginbutton).click();
	  }
	  
	}