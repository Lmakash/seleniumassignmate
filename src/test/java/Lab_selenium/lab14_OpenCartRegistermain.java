package Lab_selenium;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab14_OpenCartRegistermain {
	public static void main(String[] args) throws Exception {

	File f1=new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\inputRegister.xlsx");
	FileInputStream fis=new FileInputStream(f1);
    XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheetAt(0);
	int rowcount=sheet.getPhysicalNumberOfRows();
	System.out.println("Row count:"+rowcount);
	
	
String[][]data=new String[3][4]; 
for(int i=0;i<rowcount;i++) {
 data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
 data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();

data[i][2]=sheet.getRow(i).getCell(2).getStringCellValue();
 data[i][3]=sheet.getRow(i).getCell(3).getStringCellValue();
 String fname=data[i][0];
 String lname=data[i][1];
 String email=data[i][2];
 String pwd=data[i][3];
 WebDriverManager.chromedriver().setup();
 WebDriver driver = new ChromeDriver();
 System.out.println("firstname"+fname);
 System.out.println("lastname:"+lname);
 System.out.println("email:"+email);
 System.out.println("password:"+pwd);
  Thread.sleep(2000); 
  
	driver.get("https://demo.opencart.com/");
	
	driver.findElement(By.linkText("My Account")).click();
	driver.findElement(By.linkText("Register")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	lab14_PomOpencartRegister obj=new lab14_PomOpencartRegister(driver);

    obj.enterfirstname(fname);
    obj.enterlastname(lname);
    obj.enteremail(email);
    obj.enterpassword(pwd);
     Thread.sleep(2000);
	obj.enterradiobutton();
	obj.entercheckbox();
	obj.enterbutton2();
}
}
}