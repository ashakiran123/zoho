package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage {
	@FindBy(id="userName")
	private WebElement unTB;
	
	@FindBy(id="passWord")
	private WebElement pwTB;
	
	@FindBy(xpath="//input[@alt='Sign In']")
	private WebElement signInBTN;
	
	public SingInPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void setUserName(String un) {
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	
	public void clickSingIn() {
		signInBTN.click();
	}
}
