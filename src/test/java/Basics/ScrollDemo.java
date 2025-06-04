package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{

	@Test
	public void LongPressGestures() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
		
		scrollToEndAction();
		Thread.sleep(4000);
		
		
	}
}
