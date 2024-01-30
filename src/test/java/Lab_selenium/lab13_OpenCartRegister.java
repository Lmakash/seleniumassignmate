package Lab_selenium;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab13_OpenCartRegister {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
	

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.getTitle());
		
		File xmlfile = new File("C:\\\\Users\\\\akash.shendage\\\\eclipse-workspace\\\\JAN2024_seleniumweb1\\\\src\\\\test\\\\java\\\\Lab_selenium\\\\inputRegister.xml");
        DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder=DBFactory.newDocumentBuilder();
        Document doc = dbuilder.parse(xmlfile);
		 NodeList n1 = doc.getChildNodes();
        Node n =n1.item(0);
        Element ele=(Element)n;
        String url=ele.getElementsByTagName("url").item(0).getTextContent();
        String email=ele.getElementsByTagName("email").item(0).getTextContent();
        String pword=ele.getElementsByTagName("password").item(0).getTextContent();
        
        Lab13_OrangeHRM_POM obj = new Lab13_OrangeHRM_POM(driver);
    	driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		obj.enteremail(email);
		obj.enterpassword(pword);
		obj.clickonlogin();
	
		

	}

	}


