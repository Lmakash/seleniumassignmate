package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LumaPOM {
	WebDriver driver;
	  By fname=By.name("firstname");
	  By lname=By.name("lastname");
	  By email=By.name("Email");
	  By pword=By.name("password");
	  By cpword=By.name("cpassword");
	  By loginbutton=By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
	  By dashboard=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
	  
	  public LumaPOM(WebDriver driver2) {
		  this.driver=driver2;
	  }
	  
	  public boolean verifyfirstname()
		{
			boolean isfirstname_displayed=driver.findElement(fname).isDisplayed();
			return isfirstname_displayed;
		}
	  
	  public void enterfirstname(String firstname) {
		  driver.findElement(fname).sendKeys(firstname);
	  }
	  public boolean verifylastname()
		{
			boolean islastname_displayed=driver.findElement(lname).isDisplayed();
			return islastname_displayed;
		}
	  
	  public void enterlastname(String lastname) {
		  driver.findElement(lname).sendKeys(lastname);
	  }
	  public boolean verifyemail()
		{
			boolean isemail_displayed=driver.findElement(email).isDisplayed();
			return isemail_displayed;
		}
	  
	  public void enteremail(String Email) {
		  driver.findElement(email).sendKeys(Email);
	  }
	  public boolean verifypassword()
		{
			boolean ispassword_displayed=driver.findElement(pword).isDisplayed();
			return ispassword_displayed;
		}
		
	  public void enterpassword(String password) {
		  driver.findElement(pword).sendKeys(password);
	  }
		public boolean verifycpassword()
		{
			boolean iscpassword_displayed=driver.findElement(cpword).isDisplayed();
			return iscpassword_displayed;
		} 
		
	  public void entercpassword(String cpassword) {
		  driver.findElement(cpword).sendKeys(cpassword);
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