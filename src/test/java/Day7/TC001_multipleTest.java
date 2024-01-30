package Day7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC001_multipleTest {
  @Test( priority = 3)
  public void Test2() {
	  System.out.println("This is test2");
  }
  @Test(groups = {"sanity"},priority = 0)
  public void Test3() {
	  System.out.println("This is test3");
  }
  @Test(priority = 2)
  public void Test1() {
	  System.out.println("This is test1");
  }
  @Test(groups = {"sanity"},priority = 0)
  public void Test4() {
	  System.out.println("This is test4");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
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
