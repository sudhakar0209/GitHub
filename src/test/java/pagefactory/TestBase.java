package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver=null;
	public void getBrowser() {
		
//		System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
	
		  driver = new ChromeDriver();
		  
		  driver.get("https://demowebshop.tricentis.com");
	}
	

}
