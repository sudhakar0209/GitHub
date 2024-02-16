package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.TestBase;
import utilities.ExcelRead;

public class LoginTest extends TestBase {
	WebDriver driver;
	HomePage h;
	LoginPage l;
	ExcelRead e=new ExcelRead();
	
	@DataProvider
	public Object[][] loginData() throws IOException
	{
		int LastRow = e.getLastRow("C:\\Users\\sudha\\OneDrive\\Desktop\\testData.xlsx", "Sheet1");
		Object[][] mydata = new Object[LastRow+1][2];
		for(int i=0; i<=LastRow; i++) {
			mydata[i][0]=e.readExcel("C:\\Users\\sudha\\OneDrive\\Desktop\\testData.xlsx", "Sheet1", i, 0);
			mydata[i][1]=e.readExcel("C:\\Users\\sudha\\OneDrive\\Desktop\\testData.xlsx", "Sheet1", i, 1);
			}
		return mydata;
	}
	
  @Test(dataProvider="loginData")
  public void testLogin(String u, String p) {
	  h.clickLoginLink();
	  l.enterLoginDetails(u, p);
	  
	  try
	  {
		  l.clickLogout();
	  }catch(Exception e)
	  {
		  Assert.fail("Logout button is not present");
	  }
	  
	  
  }
  
  @BeforeClass()
  public void setup()
  {
	  getBrowser();
	  h = new HomePage();
	  l = new LoginPage();
  }
}
