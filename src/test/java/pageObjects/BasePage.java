package pageObjects;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		action  = new Actions(driver);
		PageFactory.initElements(driver,this);
	}
}
