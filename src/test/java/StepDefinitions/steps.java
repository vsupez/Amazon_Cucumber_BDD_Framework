package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.poi.poifs.crypt.DataSpaceMapUtils.DataSpaceMap;
import org.junit.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.FrontPage;
import pageObjects.SigninPage;
import utilities.DataReader;


public class steps {

	WebDriver driver;
	FrontPage fP;
	SigninPage sp;
    Logger logger; //for logging
    public ResourceBundle rb; // for reading properties file
    public String br; //to store browser name
    List<HashMap<String,String>> datamap;
    

	
    	
	@Before   
	public void setup() {
		//for logging
		logger =  LogManager.getLogger(this.getClass());
		
		//Reading config properties for browser
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
	}
	
	

	@Given("User launch browser")
	public void user_launch_browser() {
		if(br.equals("chrome"))
			driver = new ChromeDriver();
		else if(br.equals("edge"))
				driver = new EdgeDriver();
		else
			driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	
	
	@Given("Opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Given("Hover over sign in")
	public void hover_over_sign_in() {
		fP = new FrontPage(driver);
		fP.hover_over_sign_in();
		logger.info("Hovered over signin menu");
		
	}

	@Given("click sign in")
	public void click_sign_in1() {
		fP.click_sign_in();
	}

	
	@Given("Enter mobile number {string}")
	public void enter_mobile_number(String num) {
		sp = new SigninPage(driver);
		sp.enter_mobile_number(num);
	}

	
	@Given("Click Continue")
	public void click_continue() {
		sp.click_continue();
	}

	@Given("Enter password {string}")
	public void enter_password(String pwd) {
		sp.enter_password(pwd);
	}

	@Given("Click sign in")
	public void click_sign_in() {
		sp.click_sign_in();
//		try {
//		Thread.sleep(10000);
//		}
//		catch (Exception e){
//			System.out.println(e.getStackTrace());
//		}
	}

	@Then("Verify amazon Home page is opened")
	public void verify_amazon_home_page_is_opened() {
		Assert.assertTrue(driver.getCurrentUrl().contains("nav_signin"));
	}

	@Then("Verify amazon Home page is opened by passing Mobile_number and Password with excel row {string}")	
	public void check_homePage_is_opened_passing_Excel_data(String rows) {
		datamap = DataReader.data(System.getProperty("user.dir")+"\\testData\\amazon_data.xlsx","Sheet1");
		System.out.println(datamap);
		
		int index = Integer.parseInt(rows)-1;
		String mobileno = datamap.get(index).get("Mobile_number");
		String pwd = datamap.get(index).get("Password");
		System.out.println("Mobile number is :---"+mobileno);
		System.out.println("Password is ----"+pwd);

		sp = new SigninPage(driver);
		sp.enter_mobile_number(mobileno);
		sp.click_continue();
		sp.enter_password(pwd);
		sp.click_sign_in();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("nav_signin"));
	}
	
	@After 
	public void tearDown() {
//		System.out.println("Scenario status--->"+scenario.getStatus());
//		if( scenario.isFailed()) {
//        	TakesScreenshot ts=(TakesScreenshot) driver;
//        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//        	scenario.attach(screenshot, "image/png",scenario.getName());
//		}
		driver.quit();
	}	
}
