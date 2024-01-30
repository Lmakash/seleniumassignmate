package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ORHM_POM2_repo {
	WebDriver driver;
  By uname=By.name("username");
  By pword=By.name("password");
  By loginbutton=By.xpath("//button[@type='submit']");
  
  public ORHM_POM2_repo(WebDriver driver2) {
	  this.driver=driver2;
  }
  
  public void enterusername(String username) {
	  driver.findElement(uname).sendKeys(username);
  }
  public void enterpassword(String password) {
	  driver.findElement(pword).sendKeys(password);
  }
  public void clicklogin() {
	  driver.findElement(loginbutton).click();
  }
}
