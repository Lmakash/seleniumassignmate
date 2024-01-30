package Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0010_OrangeHRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   //ORHM_POM obj=new ORHM_POM(driver);
	   TC0010_OrangeHRM_PageFactory obj=PageFactory.initElements(driver,TC0010_OrangeHRM_PageFactory.class);
	   obj.enterusername("Admin");
	   obj.enterpassword("admin123");
	   obj.clicklogin();
//	   driver.findElement(By.name("username")).sendKeys("Admin");
//	   driver.findElement(By.name("password")).sendKeys("admin123");
//	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
