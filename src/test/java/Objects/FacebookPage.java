package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPage {
	
	WebDriver driver;
	
	public FacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username =By.id("email");
	By password =By.id("pass");
	By loginbtn =By.name("login");
	
	public void enterusername() {
		driver.findElement(username).sendKeys("testeruser");
	}
	
	public void enterpassword() {
		driver.findElement(password).sendKeys("testpassword");
	}
	
	public void clickLgnBtn() {
		driver.findElement(loginbtn).click();
	}

}
