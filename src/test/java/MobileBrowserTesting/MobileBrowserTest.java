package MobileBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void browserTest() {
		
		
		//Test Case1: Go to google chrome enter url and search something
/*      driver.get("https://www.google.com");
		System.out.println("Title of the page is:" +driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Welcome Shekar!");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);		*/
		
		
		//Test Case2: Go to chrome and pass the url(rahul shetty) and got to products,scroll to Devops and click on it.
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("span[class*=\"navbar\"]")).click();
		driver.findElements(By.xpath("//a[@class=\"nav-link\"]")).get(0).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", ""); //scroll
		String text=driver.findElement(By.cssSelector("a[href*=\"products/3\"]")).getText();
		Assert.assertEquals(text,"Devops");
		
		
		
	
	}

}
