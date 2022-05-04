package TestScenarios;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Objects.FacebookPage;
import Objects.GoogleSearchpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod {
	
	WebDriver driver;
	GoogleSearchpage repos;
	FacebookPage obj;
	String url = "https://www.google.com/";
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void initialize() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@Test(priority =0)
	public void search() {
		 repos = new GoogleSearchpage(driver);
		 obj = new FacebookPage(driver);
		 
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
