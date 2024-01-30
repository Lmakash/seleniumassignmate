package Day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0010_OrangeHRM_Properties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream input1=new FileInputStream("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\src\\test\\java\\Day3\\logindata.properties");
		Properties prob=new Properties();
		prob.load(input1);
		 String url=prob.getProperty("url");
		 System.out.println("The URL is:"+url);
		
		
		
		File f1=new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\inputdata.xlsx");
		FileInputStream fis=new FileInputStream(f1);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowcount=sheet.getPhysicalNumberOfRows();
		System.out.println("Row count:"+rowcount);
		
		
String[][]data=new String[3][2]; 
 for(int i=0;i<rowcount;i++) {
	 data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
	 data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
	 String uname=data[i][0];
	 String pword=data[i][1];
	 System.out.println("username"+uname);
	 System.out.println("password:"+pword);
	 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   ORHM_POM obj=new ORHM_POM(driver);
	   obj.enterusername(uname);
	   obj.enterpassword(pword);
       obj.clicklogin();
 }



}
	}


