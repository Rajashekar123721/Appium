package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{

	@Test
	public void LongPressGestures() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		//search in chrome "appium github gestures"
		longPressAction(element);
		
		
		String menuText=driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText,"Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
	}
}
