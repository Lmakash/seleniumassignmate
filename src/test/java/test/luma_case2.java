package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class luma_case2 {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String fname, String lname) throws Exception {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  
		  
		  login_pom obj = new login_pom(driver);
		  long timestamp = new Date().getTime();
		  System.out.println("The time is: "+timestamp);
		  
		  ExtentReports extent=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(timestamp+"lumacase2.html");
			extent.attachReporter(spark);
			ExtentTest test=extent.createTest("Verify the Title of Luma");
			obj.gotologin();
			String title=driver.getTitle();
			System.out.println("Title: "+title);
			 
		  if(title.equals("Customer Login"))
		  {
			  test.pass("Luma title is displayed");
			  
		  }
		  else
		  {
			  Thread.sleep(3000);
			  File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\l1.png");
			  FileUtils.copyFile(sfile, dfile);
			  String path = dfile.getAbsolutePath();
			  test.fail("Luma title is not displayed"
					  ,MediaEntityBuilder
					  .createScreenCaptureFromPath(path)
					  .build());
			  
		  }
		  if(obj.verifyusername())
		  {
			  test.pass("Luma User is displayed");
			  
		  }
		  else
		  {
			  Thread.sleep(3000);
			  File sfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile1 = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\u1.png");
			  FileUtils.copyFile(sfile1, dfile1);
			  String path1 = dfile1.getAbsolutePath();
			  test.fail("Username is not displayed"
					  ,MediaEntityBuilder
					  .createScreenCaptureFromPath(path1)
					  .build());
			  
		  }
		  if(obj.verifypassword())
		  {
			  test.pass("Password is displayed");
			  
		  }
		  else
		    {
			  Thread.sleep(3000);
			  File sfile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile2 = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\p1.png");
			  FileUtils.copyFile(sfile2, dfile2);
			  String path2 = dfile2.getAbsolutePath();
			  test.fail("password is not displayed"
					  ,MediaEntityBuilder
					  .createScreenCaptureFromPath(path2)
					  .build());
			  }
		  
		  obj.entername(fname);
		  obj.enterpword(lname);
		  obj.clicklogin();
		  if(obj.verifylogin())
		  {
			  test.pass("Login Successful");  
		  }
		  else
		  {
			  Thread.sleep(3000);
			  File sfile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile3 = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\v1.png");
			  FileUtils.copyFile(sfile3, dfile3);
			  String path3 = dfile3.getAbsolutePath();
			  test.fail("Login not Successful"
					  ,MediaEntityBuilder
					  .createScreenCaptureFromPath(path3)
					  .build());
		  }
		  obj.menshopclick();
		  obj.addcart();
		  obj.selectsize();
		  obj.selectclr();
		  obj.addtocart();
		  obj.checkcart();
		  Thread.sleep(3000);
		  if(obj.checkitem()) {
			  test.pass("item added");
		  }else {
			  Thread.sleep(3000);
			  File sfile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dfile4 = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\v1.png");
			  FileUtils.copyFile(sfile4, dfile4);
			  String path4 = dfile4.getAbsolutePath();
			  test.fail("Login not Successful"
					  ,MediaEntityBuilder
					  .createScreenCaptureFromPath(path4)
					  .build());
		  }
		  extent.flush();
		  
		  
		  
	  }
	
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  System.out.println("This is before method");
			 InputStream input1 = new FileInputStream("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\src\\test\\java\\test\\luma.properties");
				Properties prob = new Properties();
				prob.load(input1);
				String url = prob.getProperty("url");
				System.out.println("The URL is:" + url);
				
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get(url);		

				
				
		  }
	  

	  @AfterMethod
	  public void afterMethod() {
	  }


	  @DataProvider
	  public Object[][] dp() throws Exception {
		  File f1 = new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\luma_case2.xlsx");
	      FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rowCount);
			String[][] data = new String[2][2];
			
			for(int i=0;i<rowCount;i++) {
				data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			
				String name = data[i][0];
				String pass = data[i][1];
				
				System.out.println("Email: "+name);
				System.out.println("Password: "+pass);	
				
			}
			return data;
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
