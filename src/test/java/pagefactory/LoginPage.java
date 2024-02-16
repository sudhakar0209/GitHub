package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
	
@FindBy(id="Email")
public static WebElement textbox_username;

@FindBy(id="Password")
public static WebElement textbox_password;

@FindBy(xpath="//input[@value='Log in']")
public static WebElement btn_login;

@FindBy(linkText="Log out")
public static WebElement btn_Logout;

public void enterLoginDetails(String u, String p)
{
	textbox_username.sendKeys(u);
	textbox_password.sendKeys(p);
	btn_login.click();
}
public void clickLogout()
{
	btn_Logout.click();
}

public LoginPage() {
	
	PageFactory.initElements(driver, this);
	
}

}
