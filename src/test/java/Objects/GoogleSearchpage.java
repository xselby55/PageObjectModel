package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage {
	
	WebDriver driver;
	
	public GoogleSearchpage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchbox = By.xpath("//input[@title='Search']");
	By searchbtn = By.xpath("(//input[@name='btnK'])[1]");
	By faceboolnk = By.xpath("//a//h3[text()='Facebook - log in or sign up']");
	
	public void searchgoogle(String searchinput) {
		try {
		driver.findElement(searchbox).sendKeys(searchinput);
		Thread.sleep(2000);
		driver.findElement(searchbtn).click();
		Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error caught :" + e.getMessage());
		}
	}
	public void facebookLnk() {
		try {
			
			driver.findElement(faceboolnk).click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO: handle exception
			  
			System.out.println("Error caught :" + e.getMessage());
		}
	}

}
