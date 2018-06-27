package Tatoc1.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.gargoylesoftware.htmlunit.javascript.host.event.CustomEvent;
public class Test_NG {

	WebDriver driver;
	Testng obj;

	@BeforeTest
	public void setDiver() {
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/workspace/Test/chromedriver");

		driver = new ChromeDriver();
		obj = new Testng(driver);
		driver.get("http://10.0.1.86/tatoc");

	}

	@Test(priority = 1)
	public void firstCase() {
		obj.start();
		String str = obj.start();
		// action.click();
		// driver.findElement(By.linkText("Basic Course")).click();
		Assert.assertEquals(str, "http://10.0.1.86/tatoc");
	}

	@Test(priority = 2)
	public void secondCase() {
		obj.greenBox();
		// Assert.assertTrue(driver.findElement(By.className("greenbox")).isDisplayed());
	}

	@Test(priority = 3)
	public void thirdCase() {
		obj.colorMatch();
		// String str1= obj.colorMatch();
		String str2 = obj.colorMatch();
		//driver.switchTo().defaultContent();
		Assert.assertEquals(driver.switchTo().frame(0).findElement(By.xpath("//*[@id=\"answer\"]")).getAttribute("class"), str2);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Proceed")).click();
	}

	@Test(priority = 4)
	public void fourthCase() {
		obj.dragDrop();
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropbox")));
		Assert.assertTrue(driver.findElement(By.id("dropbox")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("dragbox")).isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("tatoc/drag"));

	}

	@Test(priority = 5)
	public void fifthCase() {
		obj.launchPopWindow();
		driver.findElement(By.linkText("Proceed")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("tatoc/cookie"));

	}
	@Test(priority = 6)
	public void sixthCase() {
		obj.cookieHandeling();
		Assert.assertTrue(driver.getCurrentUrl().contains("tatoc/end"));
	}

}
