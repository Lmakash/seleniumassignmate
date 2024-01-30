package Day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ORHM2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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


