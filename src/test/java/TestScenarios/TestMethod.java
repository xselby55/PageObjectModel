package TestScenarios;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Objects.FacebookPage;
import Objects.GoogleSearchpage;
import Objects.checkViewPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod {
	
	WebDriver driver;
	GoogleSearchpage repos;
	FacebookPage obj;
	checkViewPage view;
	String url = "https://www.google.com/";
	String browser = "firefox";
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void initialize() {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test(priority =0)
	public void search() {
		 repos = new GoogleSearchpage(driver);
		 obj = new FacebookPage(driver);
		 view = new checkViewPage();
		 
		 view.printStatement();
		 repos.searchgoogle("facebook");
	}
	
	@Test(priority =1)
	public void verifyFBpage() {
		repos = new GoogleSearchpage(driver);
		repos.facebookLnk();
	}
	@Test(priority =2)
	public void logintoFacebook() throws InterruptedException {
		
		 obj.enterusername();
		 obj.enterpassword();
		 obj.clickLgnBtn();
		 Thread.sleep(2000);
		 
		 String title = driver.getTitle();
		 assertEquals(title, "Log in to Facebook");
	}
	
	@AfterTest
	public void exit() {
		driver.quit();
	}

}
