package Day6;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TC004_testNG {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String uname, String pwd) throws Exception  {	
		  long timestamp=new Date().getTime();
		  System.out.println("Time is:"+timestamp);
		  Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
		    System.out.println(browserName);
		  System.out.println("This is the TEst: your credential are:"+uname+":and:"+pwd);  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		  TC003POM_orangeHRM obj = new TC003POM_orangeHRM(driver);
		  String title=driver.getTitle();
		  Assert.assertEquals(title, "OrangeHRM");
		  ExtentReports extent=new ExtentReports();
		  ExtentSparkReporter spark=new ExtentSparkReporter(timestamp+"Akash1.html");
		  extent.attachReporter(spark);
		  ExtentTest test=extent.createTest("verify the title of OrangHRM"+browserName);
		  if(title.equals("orangemHRM")) {
			  test.pass("OrangeHRM title is displayed");
		  }
		  else {
			  Thread.sleep(5000);
			  File sfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile=new File("p1.png");
			  FileUtils.copyFile(sfile,dfile);
			  String path=dfile.getAbsolutePath();
			  test.fail("OrangeHRM title is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("p1.png").build());
			  test.addScreenCaptureFromPath(path);
	
		  }
		  if(obj.verifyusername()) {
			  test.pass("username name is displayed");
		  }
		  else {
			  Thread.sleep(5000);
			  File sfile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile1=new File("p2.png");
			  FileUtils.copyFile(sfile1,dfile1);
			  String path=dfile1.getAbsolutePath();
			  test.fail("username name is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("p2.png").build());
			  test.addScreenCaptureFromPath(path);
	
		  }
		    
			 if(obj.verifypassword()) {
				  test.pass("password  is displayed");
			  }
			  else {
				  Thread.sleep(5000);
				  File sfile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  File dfile2=new File("p3.png");
				  FileUtils.copyFile(sfile2,dfile2);
				  String path=dfile2.getAbsolutePath();
				  test.fail("password  is not displayed",MediaEntityBuilder.createScreenCaptureFromPath("p3.png").build());
				  test.addScreenCaptureFromPath(path);
		
			  }
			 obj.enterusername(uname);
			obj.enterpassword(pwd);
			obj.clicklogin();
			if(obj.verifylogin()) {
				  test.pass("verifylogin  is successfully");
			  }
			  else {
				  Thread.sleep(5000);
				  File sfile3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  File dfile3=new File("p4.png");
				  FileUtils.copyFile(sfile3,dfile3);
				  String path=dfile3.getAbsolutePath();
				  test.fail("verifylogin is not successfully",MediaEntityBuilder.createScreenCaptureFromPath("p4.png").build());
				  test.addScreenCaptureFromPath(path);
		
			  }
			 extent.flush();
			 boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
		     
		      assertEquals(dashboard, true);
		   
		      
	  }
	  private void assertequals() {
		  
	  }
	  @Parameters("Browser")
	  @BeforeMethod
	  
	  public void beforeMethod(String browsername) throws Exception {
		  
		 System.out.println("This is before method");
		 InputStream input1 = new FileInputStream("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\src\\test\\java\\Day3\\logindata.properties");
			Properties prob = new Properties();
			prob.load(input1);
			String url = prob.getProperty("url");
			System.out.println("The URL is:" + url);
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.get(url);
			
			 System.out.println("The Browser is:"+browsername);
			  if(browsername.equalsIgnoreCase("chrome")) {
				  WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver();
					driver.get(url);
			  }
			  else if(browsername.equalsIgnoreCase("edge")){
				  WebDriverManager.edgedriver().setup();
					 driver = new EdgeDriver();
					driver.get(url);
			}
			  else if(browsername.equalsIgnoreCase("firefox")){
				  WebDriverManager.firefoxdriver().setup();
					 driver = new FirefoxDriver();
					driver.get(url);
			}
			  else{
				  System.out.println("Browser name is not match");
			  }
			//Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is after method");
		//  driver.quit();
	  }
	  
	  


	  @DataProvider
	  public Object[][] dp() throws Exception {
		  File f1 = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\inputdata.xlsx");
	   
	      
	      FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rowCount);
			String[][] data = new String[3][2];
			
			for(int i=0;i<rowCount;i++) {
				data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
				String uname = data[i][0];
				String pwd = data[i][1];
				System.out.println("Username: "+uname);
				System.out.println("Password: "+pwd);	
			}
			return data;
	    };
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("This is before class");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("This is after class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("This is before test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("This is after test");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("This is before suite");
	  }
	  

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("This is after suite");
	  }

	}
