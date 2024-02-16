package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	
@FindBy(linkText = "Log in")
public static WebElement LoginLink;

public HomePage() {
	
	PageFactory.initElements(driver, this);
}

public void clickLoginLink() {
	
	LoginLink.click();
}

}
