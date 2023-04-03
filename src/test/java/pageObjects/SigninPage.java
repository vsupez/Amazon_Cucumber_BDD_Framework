package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BasePage{
	
	public SigninPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="ap_email") WebElement email_mobile;
	@FindBy(id="continue") WebElement btnContinue;
	@FindBy(id="ap_password") WebElement txtpwd;
	@FindBy(id="signInSubmit") WebElement btnsubmit;
	
	
	public void enter_mobile_number(String num) {
		email_mobile.sendKeys(num);
	}
	
	
	public void click_continue() {
		btnContinue.click();
	}
	
	public void enter_password(String pwd) {
		txtpwd.sendKeys(pwd);
	}

	public void click_sign_in() {
		btnsubmit.click();
	}
}
