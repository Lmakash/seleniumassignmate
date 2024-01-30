package Day3;

import java.io.File;
import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
import java.time.Duration;
//import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0010_OrangeHRM_login_xml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub	
		File xmlfile=new File("C:\\Users\\akash.shendage\\eclipse-workspace\\JAN2024_seleniumweb1\\src\\test\\java\\Day3\\logindata.xml");
		DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder=DBFactory.newDocumentBuilder();
		Document doc=dbuilder.parse(xmlfile);
		NodeList n1=doc.getChildNodes();
		Node n=n1.item(0);
		Element ele=(Element)n;
		String url=ele.getElementsByTagName("url").item(0).getTextContent();
		String uname=ele.getElementsByTagName("username").item(0).getTextContent();
		String pword=ele.getElementsByTagName("password").item(0).getTextContent();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println("username:"+uname);
		System.out.println("password:"+pword);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   ORHM_POM obj=new ORHM_POM(driver);
	   obj.enterusername(uname);
	   obj.enterpassword(pword);
       obj.clicklogin();
 }




	}


