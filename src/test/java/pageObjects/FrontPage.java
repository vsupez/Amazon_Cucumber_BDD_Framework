package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FrontPage extends BasePage{

	public FrontPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="nav-link-accountList") WebElement menusignin;
	@FindBy(css="div#nav-al-signin a[href*='https://www.amazon.com/ap/signin']") WebElement btnSignin;
	
	public void hover_over_sign_in() {

		action.moveToElement(menusignin).perform();
	}
	
	public void click_sign_in() {

		wait.until(ExpectedConditions.visibilityOf(btnSignin)).click();
	}

}
