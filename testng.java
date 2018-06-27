package Tatoc1.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class testng {
	WebDriver driver;

	public Testng(WebDriver driver) {
		this.driver = driver;
	}
	
	public String start() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String var = driver.getCurrentUrl();
		WebElement element = driver.findElement(By.cssSelector("a[href*='basic']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return var;
	}

	public void greenBox() {
		driver.findElement(By.cssSelector("a[href*='basic']")).click();
		driver.findElement(By.className("greenbox")).click();
	}

	public String colorMatch() {
		// String var1=driver.getCurrentUrl();
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("answer"));
		String Box1_color = box1.getAttribute("class");
		String Box2_color = "";
		while (!Box1_color.equals(Box2_color)) {

			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			driver.findElement(By.cssSelector("a")).click();
			driver.switchTo().frame(0);
			Box2_color = driver.findElement(By.id("answer")).getAttribute("class");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		return Box2_color;
	}

	public void dragDrop() {

		// driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("dragbox"));
		WebElement drop = driver.findElement(By.id("dropbox"));
		action.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
	}

	public void launchPopWindow() {
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String parentwindow = driver.getWindowHandle();
		String subWindow = null;
		Set<String> windows = driver.getWindowHandles();
		Iterator itr = windows.iterator();
		while (itr.hasNext()) {
			subWindow = (String) itr.next();
		}
		driver.switchTo().window(subWindow);
		driver.findElement(By.id("name")).sendKeys("abc");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(parentwindow);
		
	}
	public void cookieHandeling() {
		driver.findElement(By.linkText("Generate Token")).click();
		   String token_value=driver.findElement(By.id("token")).getText();
		   //System.out.println(token_value);
		   String str=token_value.substring(token_value.indexOf(":")+2);
		   Cookie cookie=new Cookie("Token",str);
		   driver.manage().addCookie(cookie);
		   driver.findElement(By.linkText("Proceed")).click();
	}

}
